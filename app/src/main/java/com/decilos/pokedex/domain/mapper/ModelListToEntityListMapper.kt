package com.decilos.pokedex.domain.mapper

import com.decilos.pokedex.core.common.Mapper
import com.decilos.pokedex.data.datasource.local.database.entities.PokemonEntity
import com.decilos.pokedex.domain.model.PokemonModel

class ModelListToEntityListMapper : Mapper<List<PokemonModel>, List<PokemonEntity>> {

    override fun mapFrom(from: List<PokemonModel>): List<PokemonEntity> {
        return ArrayList<PokemonEntity>().apply {
            from.forEach { pokemon ->
                add(ModelToEntityMapper().mapFrom(pokemon))
            }
        }
    }
}
