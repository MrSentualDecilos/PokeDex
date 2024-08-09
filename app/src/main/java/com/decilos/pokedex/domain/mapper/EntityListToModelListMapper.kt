package com.decilos.pokedex.domain.mapper

import com.decilos.pokedex.core.common.Mapper
import com.decilos.pokedex.data.datasource.local.database.entities.PokemonEntity
import com.decilos.pokedex.domain.model.PokemonModel

class EntityListToModelListMapper : Mapper<List<PokemonEntity>, List<PokemonModel>> {

    override fun mapFrom(from: List<PokemonEntity>): List<PokemonModel> {
        return ArrayList<PokemonModel>().apply {
            from.forEach { pokemon ->
                add(PokemonEntityMapper().mapFrom(pokemon))
            }
        }
    }
}
