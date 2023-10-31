package com.example.demokotlin.Heroes

import com.example.demokotlin.Heroes.Repositories.HeroRepository

class HeroProvider(val repository: HeroRepository) {

    suspend fun GetPaginatedHeroes(currentOffset: Int, paginationSize: Int): MutableList<HeroData> {
        return repository.GetHeroes(currentOffset, paginationSize);
    }
}