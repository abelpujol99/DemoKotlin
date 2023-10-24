package com.example.demokotlin.Heroes

import com.example.demokotlin.Heroes.Repositories.HeroRepository

class HeroProvider(val repository: HeroRepository) {

    suspend fun GetAllHeroes(): MutableList<HeroData> {
        return repository.GetHeroes();
    }
}