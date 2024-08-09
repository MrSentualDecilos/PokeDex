package com.decilos.pokedex.domain.mapper

import com.decilos.pokedex.core.common.Mapper
import com.decilos.pokedex.data.datasource.local.database.entities.PokemonEntity
import com.decilos.pokedex.domain.model.PokemonModel

class PokemonEntityMapper : Mapper<PokemonEntity, PokemonModel> {
    override fun mapFrom(from: PokemonEntity): PokemonModel {
        return PokemonModel(
            name = from.name,
            url = from.url,
            detail = from.detail
        )
    }
}
