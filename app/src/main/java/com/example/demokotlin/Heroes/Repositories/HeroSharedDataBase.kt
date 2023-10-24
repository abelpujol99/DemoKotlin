package com.example.demokotlin.Heroes.Repositories

import com.example.apuntesclasecdi.Utils.Shared
import com.example.demokotlin.Heroes.HeroData

class HeroSharedDataBase : HeroRepository {
    override suspend fun GetHeroes(): MutableList<HeroData> {
        return Shared.Heroes;
    }
}