package com.decilos.pokedex.domain.mapper

import com.decilos.pokedex.core.common.Mapper
import com.decilos.pokedex.data.datasource.remote.response.PokemonDetailResponse
import com.decilos.pokedex.domain.model.AbilitiesModel
import com.decilos.pokedex.domain.model.PokemonDetailModel
import com.decilos.pokedex.domain.model.StatsModel
import com.decilos.pokedex.domain.model.TypeModel

class PokemonDetailMapper : Mapper<PokemonDetailResponse, PokemonDetailModel> {
    override fun mapFrom(from: PokemonDetailResponse): PokemonDetailModel {
        return PokemonDetailModel(
            id = from.id,
            height = from.height,
            weight = from.weight,
            name = from.name,
            order = from.order,
            sprites = SpritesMapper().mapFrom(from.sprites),
            stats = ArrayList<StatsModel>().apply {
                from.stats.forEach { stat ->
                    add(StatsMapper().mapFrom(stat))
                }
            },
            types = ArrayList<TypeModel>().apply {
                from.types.forEach { type ->
                    add(TypeMapper().mapFrom(type))
                }
            },
            abilities =  ArrayList<AbilitiesModel>().apply {
                from.abilities.forEach { ability ->
                    add(AbilitiesMapper().mapFrom(ability))
                }
            }
        )
    }

}