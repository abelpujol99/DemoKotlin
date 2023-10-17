package com.example.demokotlin

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demokotlin.Heroes.HeroAdapter
import com.example.demokotlin.Heroes.HeroData
import com.example.demokotlin.Heroes.HeroRepository

class MainActivity : ComponentActivity() {

    val table by lazy {findViewById<RecyclerView>(R.id.myHeroesTable)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        table.layoutManager = LinearLayoutManager(this)

        table.adapter = HeroAdapter(HeroRepository.GetAllHeroes())
    }
}