package com.example.apuntesclasecdi.Utils

import android.content.Context
import android.content.SharedPreferences
import com.example.demokotlin.MyApp
import com.example.demokotlin.Heroes.HeroData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

typealias Shared = SharedPreferencesManager

object SharedPreferencesManager {
    private const val MyPreferencesName = "MySharedPreferencesStorage"

    private val shared: SharedPreferences by lazy { MyApp.Context.getSharedPreferences(MyPreferencesName, Context.MODE_PRIVATE) }
    private val editor: SharedPreferences.Editor by lazy { shared.edit() }


    private const val TimesOpenAppKey = "AppOpenTimes"
    public var TimesOpenApp: Int
        get() = shared.getInt(TimesOpenAppKey, 0)
        set(value) {
            editor.putInt(TimesOpenAppKey, value)
            editor.apply()
        }

    private const val HeroesKey = "Heroes"
    public var Heroes : MutableList<HeroData>
        get() {
            val jsonString = shared.getString(HeroesKey, "")
            val listType = object : TypeToken<MutableList<HeroData>?>() {}.type
            val heroList: MutableList<HeroData>? = Gson().fromJson(jsonString, listType)
            return heroList ?: mutableListOf()
        }
        set(value){
            val jsonString = Gson().toJson(value);
            editor.putString(HeroesKey, jsonString)
            editor.apply()
        }
}