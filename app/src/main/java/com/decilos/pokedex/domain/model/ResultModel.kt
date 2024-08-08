package com.decilos.pokedex.domain.model

import com.decilos.pokedex.data.datasource.remote.response.PokemonResponse

data class ResultModel(
    val count: Int = 0,
    val next: String = "",
    val previous: String ="",
    val results: List<PokemonResponse> = emptyList()
)
