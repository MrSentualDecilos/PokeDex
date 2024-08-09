package com.decilos.pokedex.domain.mapper

import com.decilos.pokedex.core.common.Mapper
import com.decilos.pokedex.data.datasource.remote.response.PokemonResponse
import com.decilos.pokedex.domain.model.PokemonModel

class PokemonMapper : Mapper<PokemonResponse, PokemonModel> {
    override fun mapFrom(from: PokemonResponse): PokemonModel {
        return PokemonModel(
            name = from.name,
            url = from.url,
            detail = from.detail
        )
    }
}
