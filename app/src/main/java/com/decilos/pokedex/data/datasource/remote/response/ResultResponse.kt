package com.decilos.pokedex.data.datasource.remote.response

data class ResultResponse(
    val count: Int = 0,
    val next: String = "",
    val previous: String ="",
    val results: List<PokemonResponse> = emptyList()
)
