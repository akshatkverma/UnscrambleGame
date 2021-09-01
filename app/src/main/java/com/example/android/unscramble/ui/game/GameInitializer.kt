package com.example.android.unscramble.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android.unscramble.R
import com.example.android.unscramble.databinding.GameInitializerBinding

class GameInitializer: Fragment() {

    private lateinit var binding: GameInitializerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.game_initializer, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.submitButton.setOnClickListener{ performAction() }
    }


    private fun setErrorTextFieldInitializer(error: Boolean) {
        if (error) {
            binding.textField.isErrorEnabled = true
            binding.textField.error = getString(R.string.enter_valid)
        } else {
            binding.textField.isErrorEnabled = false
            binding.textInputEditText.text = null
        }
    }

    private fun performAction(){
        val stringWeReceived=binding.textInputEditText.text.toString()
        val maxNo=stringWeReceived.toDouble()
        MAX_NO_OF_WORDS= maxNo.toInt()
        if(MAX_NO_OF_WORDS<=0)
            setErrorTextFieldInitializer(true)
        else
            setErrorTextFieldInitializer(false)

        if(MAX_NO_OF_WORDS>0) {
            val action=GameInitializerDirections.actionGameInitializerToGameFragment()
            findNavController().navigate(action)
        }
    }
}