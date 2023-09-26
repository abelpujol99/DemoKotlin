package com.example.demokotlin

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.demokotlin.ui.theme.DemoKotlinTheme

class MainActivity : ComponentActivity() {

    
    open class Fruit(val name: String = "Generic Fruit") {
        
    }
    
    class Apple(): Fruit("Apple") {
        fun AppleFunc(){
            
        }
    }
    
    class Banana(): Fruit("Banana"){
        fun BananaFunc(){
            
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoKotlinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column() {

                        val fruits = listOf(Banana(), Apple(), null)
                        
                        fruits.forEach{ fruit ->
                            when(fruit){
                                is Banana -> {
                                    fruit.BananaFunc()
                                }
                                
                                is Apple -> {
                                    fruit.AppleFunc()
                                }
                                
                                else -> PrintToScreen(name = "I don't know")
                            }
                        }

                        val weekDay = "Monday"

                        when(weekDay){
                            "Monday" -> "Today is monday"
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun PrintToScreen(name: String, modifier: Modifier = Modifier, color: Color? = null) {

    Text(
        text = name,
        modifier = modifier,
        color = color ?: Color.Black
    )
}