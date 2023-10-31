package com.example.demokotlin.Screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apuntesclasecdi.Utils.Shared
import com.example.demokotlin.Heroes.HeroAdapter
import com.example.demokotlin.Heroes.HeroData
import com.example.demokotlin.Heroes.HeroProvider
import com.example.demokotlin.Heroes.Repositories.HeroApiRepository
import com.example.demokotlin.Heroes.Repositories.HeroMockRepository
import com.example.demokotlin.Heroes.Repositories.HeroSharedDataBase
import com.example.demokotlin.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    val table by lazy {findViewById<RecyclerView>(R.id.myHeroesTable)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        table.layoutManager = LinearLayoutManager(this)

        val repository = HeroMockRepository();
        //val repository = HeroSharedDataBase();
        //val repository = HeroApiRepository();

        table.adapter = HeroAdapter(repository)
    }
}