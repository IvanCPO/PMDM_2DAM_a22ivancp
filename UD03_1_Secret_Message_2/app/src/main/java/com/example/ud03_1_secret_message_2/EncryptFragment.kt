package com.example.ud03_1_secret_message_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class EncryptFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val messageEcrypt = EncryptFragmentArgs.fromBundle(requireArguments()).message.uppercase()
        val view = inflater.inflate(R.layout.fragment_encrypt, container, false)
        view.findViewById<TextView>(R.id.encrypt_textValue).text = cifrado(messageEcrypt)
        return view
    }
    fun cifrado (message : String): String {
        var kaka = message.map {
            if (it.code >='A'.code && it.code <='Z'.code)
                (((it.code.minus('A'.code)).plus(3)).mod(26).plus('A'.code)).toChar()
            else if (it.code >='a'.code && it.code <='z'.code)
                (((it.code.minus('a'.code)).plus(3)).mod(26).plus('a'.code)).toChar()
            else it
        }.joinToString("")
        return kaka
    }

}