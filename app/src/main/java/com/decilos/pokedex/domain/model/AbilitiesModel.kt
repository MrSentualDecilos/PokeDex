package com.decilos.pokedex.domain.model

data class AbilitiesModel(
    val isHidden: Boolean,
    val slot: Int?,
    val ability: AbilityModel
)
