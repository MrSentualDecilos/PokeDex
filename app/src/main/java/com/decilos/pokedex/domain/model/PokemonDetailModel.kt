package com.decilos.pokedex.domain.model

data class PokemonDetailModel(
    val id: Int?,
    val height: Int?,
    val weight: Int?,
    val name: String?,
    val order: String?,
    val sprites: SpriteModel,
    val stats: List<StatsModel>,
    val type: List<TypeModel>,
    val abilities: List<AbilitiesModel>
)
