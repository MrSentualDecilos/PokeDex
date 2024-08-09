package com.decilos.pokedex.data.datasource.local.database.converter

import androidx.room.TypeConverter
import com.decilos.pokedex.domain.model.PokemonDetailModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PokemonDetailConverter {
    val gson = Gson()

    @TypeConverter
    fun pokemonDetailToString(pokemondetail: PokemonDetailModel): String {
        return gson.toJson(pokemondetail)
    }

    @TypeConverter
    fun stringToPokemonDetailModel(detailString: String): PokemonDetailModel {
        val objectType = object : TypeToken<PokemonDetailModel>() {}.type
        return gson.fromJson(detailString, objectType)
    }
}
