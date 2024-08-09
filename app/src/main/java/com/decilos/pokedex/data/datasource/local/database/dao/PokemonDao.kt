package com.decilos.pokedex.data.datasource.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.decilos.pokedex.data.datasource.local.database.entities.PokemonEntity

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemon_table")
    suspend fun getPokemons(): List<PokemonEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPokemons(pokemon: List<PokemonEntity>)

    @Query("DELETE FROM pokemon_table")
    suspend fun deleteAllPokemon()
}
