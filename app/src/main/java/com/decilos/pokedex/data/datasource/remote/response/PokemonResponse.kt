package com.decilos.pokedex.data.datasource.remote.response

import com.decilos.pokedex.domain.model.PokemonDetailModel

data class PokemonResponse(
    val name: String = "",
    val url: String = "",
    var detail: PokemonDetailModel = PokemonDetailModel()
)
