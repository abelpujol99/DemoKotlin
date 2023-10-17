package com.example.demokotlin.Heroes

class HeroRepository {

    companion object{

        private val heroesListHardcoded = listOf(
            HeroData("Aquaman", "Es un pez"),
            HeroData("Superman", "Debil ante una gema verde"),
            HeroData("Batman", "Es huerfano"),
            HeroData("SpiderCerdo", "Es un pez"),
            HeroData("SpiderCerdo", "Es un pez"),
            HeroData("SpiderCerdo", "Es un pez"),
            HeroData("SpiderCerdo", "Es un pez"),
            HeroData("SpiderCerdo", "Es un pez"),
            HeroData("SpiderCerdo", "Es un pez"),
            HeroData("SpiderCerdo", "Es un pez")
            )

        fun GetAllHeroes(): List<HeroData> = heroesListHardcoded
    }
}