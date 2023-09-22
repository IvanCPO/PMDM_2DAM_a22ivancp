package com.example.ud01_1_primer_proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonSearch : Button = findViewById<Button>(R.id.button)
        buttonSearch.setOnClickListener {
            val listWine : Spinner = findViewById(R.id.wineType)
            val textWine : TextView = findViewById(R.id.textTypeWine)
            textWine.text= getWine(listWine.id).joinToString(", ")
        }

    }
    fun getWine(id:Int) : Array<String> = when (id) {
        0 -> arrayOf("Albariño", "Moscato", "Verdejo")
        1 -> arrayOf("Rioja", "Ribera del Duero", "Toro")
        2 -> arrayOf("Carbernet", "Franc", "Merlot")
        else -> arrayOf()
    }
}