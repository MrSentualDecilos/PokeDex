package com.decilos.pokedex.domain.mapper

import com.decilos.pokedex.core.common.Mapper
import com.decilos.pokedex.data.datasource.local.database.entities.PokemonEntity
import com.decilos.pokedex.domain.model.PokemonModel

class ModelToEntityMapper : Mapper<PokemonModel, PokemonEntity> {

    override fun mapFrom(from: PokemonModel): PokemonEntity {
        return PokemonEntity(
            name = from.name,
            url =  from.url,
            detail = from.detail
        )
    }
}
