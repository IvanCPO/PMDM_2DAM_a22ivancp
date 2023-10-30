package com.example.ud03_2_practica

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class IntroduceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val res = inflater.inflate(R.layout.fragment_introduce, container, false)

        val button = res.findViewById<Button>(R.id.button_continue)
        val name = res.findViewById<EditText>( R.id.text_name )
        button.setOnClickListener {

        }

        return res
    }

}