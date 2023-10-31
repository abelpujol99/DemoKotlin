package com.example.demokotlin.Heroes.Repositories

import com.example.apuntesclasecdi.Utils.Shared
import com.example.demokotlin.Heroes.HeroData

class HeroSharedDataBase : HeroRepository {
    override suspend fun GetHeroes(offset: Int, limit: Int): MutableList<HeroData> {

        val heroes = Shared.Heroes;

        if (heroes.size <= offset)
        {
            return mutableListOf()
        }

        if(heroes.size <= offset + limit)
        {
            return heroes.subList(offset, heroes.size - 1)
        }

        return heroes.subList(offset, limit);
    }
}