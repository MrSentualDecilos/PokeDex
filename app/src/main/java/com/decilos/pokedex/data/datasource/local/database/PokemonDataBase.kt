package com.decilos.pokedex.data.datasource.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.decilos.pokedex.data.datasource.local.database.converter.PokemonDetailConverter
import com.decilos.pokedex.data.datasource.local.database.dao.PokemonDao
import com.decilos.pokedex.data.datasource.local.database.entities.PokemonEntity

@Database(entities = [PokemonEntity::class], version = 1)
@TypeConverters(PokemonDetailConverter::class)
abstract class PokemonDataBase: RoomDatabase() {

    abstract fun getPokemonDao(): PokemonDao
}