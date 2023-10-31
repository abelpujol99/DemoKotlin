package com.example.demokotlin.Screens

import android.os.Build
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.demokotlin.Heroes.HeroData
import com.example.demokotlin.R

class HeroDetailScreen : ComponentActivity() {

    val nameText by lazy {findViewById<TextView>(R.id.hero_detail_title)}
    val desriptionText by lazy {findViewById<TextView>(R.id.hero_detail_description)}
    val backArrow by lazy {findViewById<ImageButton>(R.id.hero_detail_back_arrow)}
    val deleteButton by lazy {findViewById<ImageButton>(R.id.hero_detail_delete_button)}

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hero_detail)

        var hero: HeroData?

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hero = intent.getSerializableExtra("Hero", HeroData::class.java)
        }
        else {
            hero = intent.getSerializableExtra("Hero") as? HeroData
        }

        hero?.let {
            nameText.text = hero.name
            desriptionText.text = hero.description
        }

        backArrow.setOnClickListener {
            finish()
        }

        //deleteButton.setOnClickListener {  }

    }
}