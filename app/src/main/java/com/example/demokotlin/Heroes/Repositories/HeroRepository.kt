package com.example.demokotlin.Heroes.Repositories

import com.example.demokotlin.Heroes.HeroData

interface HeroRepository {

    suspend fun GetHeroes(offset: Int, limit: Int) : MutableList<HeroData>

}