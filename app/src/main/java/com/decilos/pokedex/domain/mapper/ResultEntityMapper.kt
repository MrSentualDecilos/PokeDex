package com.decilos.pokedex.domain.mapper

import com.decilos.pokedex.core.common.Mapper
import com.decilos.pokedex.data.datasource.local.database.entities.ResultEntity
import com.decilos.pokedex.domain.model.PokemonModel
import com.decilos.pokedex.domain.model.ResultModel

class ResultEntityMapper : Mapper<ResultEntity, ResultModel> {

    override fun mapFrom(from: ResultEntity): ResultModel {
        return ResultModel(
            count = from.count,
            next = from.next,
            previous = from.previous,
            results = ArrayList<PokemonModel>().apply {
                from.results.forEach { pokemon ->
                    add(PokemonEntityMapper().mapFrom(pokemon))
                }
            }
        )
    }
}
