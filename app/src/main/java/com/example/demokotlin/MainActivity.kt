package com.example.demokotlin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doBeforeTextChanged


class MainActivity : ComponentActivity() {

    val startText: TextView by lazy { findViewById(R.id.startScreenText) }
    val startButton: Button by lazy { findViewById(R.id.startScreenButton) }
    val startEditText: EditText by lazy { findViewById(R.id.startScreenEditText) }

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