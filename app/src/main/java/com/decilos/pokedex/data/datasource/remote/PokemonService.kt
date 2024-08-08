package com.decilos.pokedex.data.datasource.remote

import com.decilos.pokedex.data.network.PokemonApi
import com.decilos.pokedex.domain.model.PokemonDetailModel
import com.decilos.pokedex.domain.model.ResultModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class PokemonService @Inject constructor(private val api: PokemonApi) {

    suspend fun getPokemons(
        limit: Int,
        offSet: Int
    ) : ResultModel {
        return withContext(Dispatchers.IO) {
            val response: Response<ResultModel> = api.getAllPokemon(limit, offSet)
            response.body() ?: ResultModel()
        }
    }

    suspend fun getPokemonDetail(name: String) : PokemonDetailModel {
        return withContext(Dispatchers.IO) {
            val response: Response<PokemonDetailModel> = api.getPokemonDetail(name)
            response.body() ?: PokemonDetailModel()
        }
    }
}
