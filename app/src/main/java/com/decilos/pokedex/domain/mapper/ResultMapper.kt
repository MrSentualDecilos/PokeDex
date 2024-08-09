package com.decilos.pokedex.domain.mapper

import com.decilos.pokedex.core.common.Mapper
import com.decilos.pokedex.data.datasource.remote.response.ResultResponse
import com.decilos.pokedex.domain.model.PokemonModel
import com.decilos.pokedex.domain.model.ResultModel

class ResultMapper : Mapper<ResultResponse, ResultModel> {
    override fun mapFrom(from: ResultResponse): ResultModel {
        return ResultModel(
            count = from.count,
            next = from.next,
            previous = from.previous,
            results = ArrayList<PokemonModel>().apply {
                from.results.forEach { pokemon ->
                    add(PokemonMapper().mapFrom(pokemon))
                }
            }
        )
    }

}