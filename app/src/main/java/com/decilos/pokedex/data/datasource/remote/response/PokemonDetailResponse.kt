package com.decilos.pokedex.data.datasource.remote.response

data class PokemonDetailResponse(
    val id: Int = 0,
    val height: Int = 0,
    val weight: Int = 0,
    val name: String = "",
    val order: String = "",
    val sprites: SpritesResponse = SpritesResponse(),
    val stats: List<StatsResponse> = emptyList(),
    val types: List<TypeResponse> = emptyList(),
    val abilities: List<AbilitiesResponse> = emptyList()
)
