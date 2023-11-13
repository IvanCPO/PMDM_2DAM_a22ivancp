package com.example.ud03_1_secret_message_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ud03_1_secret_message_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate
        setContentView(R.layout.activity_main)
    }
}