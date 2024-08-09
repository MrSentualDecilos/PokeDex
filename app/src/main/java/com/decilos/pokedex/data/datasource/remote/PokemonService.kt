package com.decilos.pokedex.data.datasource.remote

import com.decilos.pokedex.data.datasource.remote.response.PokemonDetailResponse
import com.decilos.pokedex.data.datasource.remote.response.ResultResponse
import com.decilos.pokedex.data.network.PokemonApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class PokemonService @Inject constructor(private val api: PokemonApi) {

    suspend fun getPokemons(
        limit: Int,
        offSet: Int
    ) : ResultResponse {
        return withContext(Dispatchers.IO) {
            val response: Response<ResultResponse> = api.getAllPokemon(limit, offSet)
            response.body() ?: ResultResponse()
        }
    }

    suspend fun getPokemonDetail(name: String) : PokemonDetailResponse {
        return withContext(Dispatchers.IO) {
            val response: Response<PokemonDetailResponse> = api.getPokemonDetail(name)
            response.body() ?: PokemonDetailResponse()
        }
    }
}
