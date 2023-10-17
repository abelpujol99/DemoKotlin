package com.example.demokotlin

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    val testButton by lazy {findViewById<Button>(R.id.test_button)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        testButton.setOnClickListener {
            val toast = Toast(this)
            toast.setText("Soy muy molon")
            toast.duration = Toast.LENGTH_SHORT
            toast.show()
        }
    }
}