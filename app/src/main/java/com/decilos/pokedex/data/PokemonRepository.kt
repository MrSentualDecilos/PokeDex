package com.decilos.pokedex.data

import com.decilos.pokedex.data.datasource.local.database.dao.PokemonDao
import com.decilos.pokedex.data.datasource.local.database.entities.PokemonEntity
import com.decilos.pokedex.data.datasource.remote.PokemonService
import com.decilos.pokedex.domain.mapper.EntityListToModelListMapper
import com.decilos.pokedex.domain.mapper.PokemonDetailMapper
import com.decilos.pokedex.domain.mapper.ResultMapper
import com.decilos.pokedex.domain.model.PokemonDetailModel
import com.decilos.pokedex.domain.model.PokemonModel
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val api: PokemonService,
    private val pokemonDao: PokemonDao
){

    suspend fun getAllPokemonsFromService(limit: Int, offSet: Int): List<PokemonModel> {
        val response = api.getPokemons(limit, offSet)
        return ResultMapper().mapFrom(response).results
    }

    suspend fun getPokemonDetailFromService(name: String): PokemonDetailModel {
        val response = api.getPokemonDetail(name)
        return PokemonDetailMapper().mapFrom(response)
    }

    suspend fun getAllPokemonFromDataBase(): List<PokemonModel>{
        val response = pokemonDao.getPokemons()
        return EntityListToModelListMapper().mapFrom(response)
    }

    suspend fun insertPokemonToDataBase(list: List<PokemonEntity>) {
        pokemonDao.insertAllPokemons(list)
    }

    suspend fun clearPokemon() {
        pokemonDao.deleteAllPokemon()
    }
}
