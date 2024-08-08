package com.decilos.pokedex.data

import com.decilos.pokedex.data.datasource.remote.PokemonService
import com.decilos.pokedex.data.datasource.remote.response.PokemonResponse
import com.decilos.pokedex.domain.model.PokemonDetailModel
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val api: PokemonService,
    private val provider: PokemonProvider
){

    suspend fun getAllPokemons(limit: Int, offSet: Int) : List<PokemonResponse> {
        val response = api.getPokemons(limit, offSet)
        provider.pokemons = response.results
        return response.results
    }

    suspend fun getPokemonDetail(name: String) : PokemonDetailModel {
        val response = api.getPokemonDetail(name)
        provider.pokemonDetail = response
        return response
    }
}
