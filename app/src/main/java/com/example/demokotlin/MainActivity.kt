package com.example.demokotlin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent



class MainActivity : ComponentActivity() {

    val startText: TextView by lazy { findViewById(R.id.startScreenText) }
    val startButton: TextView by lazy { findViewById(R.id.startScreenButton) }

    var counter = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        startButton.setOnClickListener{
            counter++
            startText.text = "holi $counter"
        }
    }
}