package com.example.demokotlin.Heroes.Repositories

import com.example.demokotlin.Heroes.HeroData

class HeroMockRepository : HeroRepository{

    companion object{

        private val heroesListHardcoded = mutableListOf<HeroData>(
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

    }

    override suspend fun GetHeroes(): MutableList<HeroData> {
        return heroesListHardcoded;
    }
}