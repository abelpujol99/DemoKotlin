package com.example.demokotlin


import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Soy un Alert")
            builder.setMessage("Y yo soy su mensaje")

            builder.setPositiveButton("OK"){ dialog, which ->
                dialog.dismiss()
            }

            builder.setNeutralButton("?"){ dialog, which ->
                dialog.dismiss()
            }

            builder.setNegativeButton("NO"){ dialog, which ->
                dialog.dismiss()
            }

            val options = arrayOf("Respuesta 1", "Respuesta 2", "Respuesta 3", "Respuesta 4")
            val selectedItems = booleanArrayOf(false, false, false, false)

            /*builder.setMultiChoiceItems(options, selectedItems) {dialog, which, isChecked ->
                selectedItems[which] = isChecked
            }*/

            //builder.setCancelable(false)
            builder.setOnCancelListener{
                val toast = Toast(this)
                toast.setText("Alert has been cancelled")
                toast.show()
            }

            val linearLayout = LinearLayout(this)

            linearLayout.orientation = LinearLayout.VERTICAL

            val input = EditText(this)
            input.hint = "Escribe aqui"

            val input2 = EditText(this)
            input2.hint = "Escribe aqui"

            linearLayout.addView(input)
            linearLayout.addView(input2)

            builder.setView(linearLayout)

            val dialog = builder.create()
            dialog.show()
        }
    }
}