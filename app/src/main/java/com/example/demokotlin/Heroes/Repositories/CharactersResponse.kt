package com.example.demokotlin.Heroes.Repositories

import com.example.demokotlin.Heroes.HeroData
import com.google.gson.annotations.SerializedName

data class CharactersResponse(val code: Int, @SerializedName("data") val charactersData: CharacterResponseData)

data class CharacterResponseData(val offset: Int, val count: Int, val total: Int, @SerializedName("results") val heroList: MutableList<HeroData>)
