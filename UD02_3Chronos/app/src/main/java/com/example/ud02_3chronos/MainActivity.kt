package com.example.ud02_3chronos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {
    lateinit var chrono: Chronometer
    var running = false
    var offset : Long = 0
    val RUNNING_KEY = "running"
    val OFFSET_KEY = "offset"
    val BASE_KEY = "base"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chrono = findViewById<Chronometer>(R.id.chrono)

        if (savedInstanceState != null){
            offset= savedInstanceState.getLong(OFFSET_KEY)
            running= savedInstanceState.getBoolean(RUNNING_KEY)
            chrono.base = savedInstanceState.getLong(BASE_KEY)
            if (running) {
                chrono.base = savedInstanceState.getLong(BASE_KEY)
                chrono.start()
            }else{
                chrono.base = SystemClock.elapsedRealtime() - offset
            }
        }

        var btnStart = findViewById<Button>(R.id.btn_start)
        btnStart.setOnClickListener {
            if (!running){
                chrono.base = SystemClock.elapsedRealtime()-offset
                chrono.start()
                running = true
            }
        }

        var btnPause = findViewById<Button>(R.id.btn_pause)
        btnPause.setOnClickListener {
            if (running){
                offset=SystemClock.elapsedRealtime()-chrono.base
                chrono.stop()
                running = false

            }
        }

        var btnRestart = findViewById<Button>(R.id.btn_restart)
        btnRestart.setOnClickListener {
            offset = 0
            chrono.base = SystemClock.elapsedRealtime()


        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(RUNNING_KEY, running)
        outState.putLong(OFFSET_KEY, offset)
        outState.putLong(BASE_KEY, chrono.base)
        super.onSaveInstanceState(outState)
    }
}