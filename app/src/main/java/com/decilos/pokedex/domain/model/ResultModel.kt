package com.decilos.pokedex.domain.model

data class ResultModel(
    val count: Int = 0,
    val next: String?,
    val previous: String?,
    val results: List<PokemonModel> = emptyList()
)
