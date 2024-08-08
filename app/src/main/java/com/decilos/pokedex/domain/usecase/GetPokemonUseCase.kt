package com.decilos.pokedex.domain.usecase

import com.decilos.pokedex.data.PokemonRepository
import com.decilos.pokedex.data.datasource.remote.response.PokemonResponse
import com.decilos.pokedex.domain.model.PokemonDetailModel
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend fun getPokemons(limit: Int, offSet: Int) : List<PokemonResponse> = repository.getAllPokemons(limit, offSet)
    suspend fun getPokemonDetail(name: String) : PokemonDetailModel = repository.getPokemonDetail(name)
}