package com.decilos.pokedex.data.network

import com.decilos.pokedex.data.datasource.remote.response.PokemonResponse
import com.decilos.pokedex.domain.model.PokemonDetailModel
import com.decilos.pokedex.domain.model.ResultModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {
    @GET("api/v2/pokemon")
    suspend fun getAllPokemon(
        @Query("limit") limitValue: Int,
        @Query("offset") offSet: Int
    ) : Response<ResultModel>

    @GET("api/v2/pokemon/{name}")
    suspend fun getPokemonDetail(@Path("name") name: String) : Response<PokemonDetailModel>
}
