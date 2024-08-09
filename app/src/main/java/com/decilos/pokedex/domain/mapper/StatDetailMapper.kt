package com.decilos.pokedex.domain.mapper

import com.decilos.pokedex.core.common.Mapper
import com.decilos.pokedex.data.datasource.remote.response.StatDetailResponse
import com.decilos.pokedex.domain.model.StatDetailModel

class StatDetailMapper : Mapper<StatDetailResponse, StatDetailModel> {
    override fun mapFrom(from: StatDetailResponse): StatDetailModel {
        return StatDetailModel(
            name = from.name,
            url = from.url
        )
    }
}
