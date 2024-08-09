package com.decilos.pokedex.domain.mapper

import com.decilos.pokedex.core.common.Mapper
import com.decilos.pokedex.data.datasource.remote.response.StatsResponse
import com.decilos.pokedex.domain.model.StatsModel

class StatsMapper : Mapper<StatsResponse, StatsModel> {
    override fun mapFrom(from: StatsResponse): StatsModel {
        return StatsModel(
            baseStat = from.baseStat,
            stat = StatDetailMapper().mapFrom(from.stat)
        )
    }
}
