package com.decilos.pokedex.data.datasource.remote.response


data class AbilitiesResponse(
    val isHidden: Boolean,
    val slot: Int?,
    val ability: AbilityResponse
)
