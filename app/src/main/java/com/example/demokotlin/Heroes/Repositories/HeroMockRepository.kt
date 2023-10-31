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

    override suspend fun GetHeroes(offset: Int, limit: Int): MutableList<HeroData> {

        val heroes = heroesListHardcoded

        if (heroes.size <= offset)
        {
            return mutableListOf()
        }

        if(heroes.size <= offset + limit)
        {
            return heroes.subList(offset,heroes.size - 1)
        }

        return heroesListHardcoded.subList(offset, limit);
    }
}