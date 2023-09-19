package com.example.demokotlin

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.demokotlin.ui.theme.DemoKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoKotlinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PrintToScreen("Abel", "Abel2")
                }
            }
        }
    }
}

@Composable
fun PrintToScreen(name: String?, name2: String?, modifier: Modifier = Modifier) {

    val name = name ?: run{
        Log.e("NullError", "Name is Null")
        return
    }

    val name2 = name2 ?: run{
        Log.e("NullError", "Name2 is Null")
        return
    }

    Text(
        text = "Hello ${name}! ${name2}",
        modifier = modifier
    )

    /*name?.let {name ->
        name2?.let {name2 ->
            Text(
                text = "Hello ${name}! ${name2}",
                modifier = modifier
            )
        } ?: run{
            Log.e("NullError", "Name2 is Null")
        }
    } ?: run{
        Log.e("NullError", "Name is Null")
    }*/
}