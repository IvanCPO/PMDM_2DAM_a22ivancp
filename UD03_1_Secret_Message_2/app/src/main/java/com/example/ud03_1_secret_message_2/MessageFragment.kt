package com.example.ud03_1_secret_message_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.findNavController

class MessageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_message, container, false)
        val button = view.findViewById<Button>(R.id.button_next)
        button.setOnClickListener {
            val message = view.findViewById<EditText>(R.id.edit_text).text.toString()
            val actions = MessageFragmentDirections.actionMessageFragmentToEncryptFragment(message)
            view.findNavController().navigate(actions)
        }

        return view
    }

}