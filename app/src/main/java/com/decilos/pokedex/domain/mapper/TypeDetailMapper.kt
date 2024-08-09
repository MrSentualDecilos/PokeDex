package com.decilos.pokedex.domain.mapper

import com.decilos.pokedex.core.common.Mapper
import com.decilos.pokedex.data.datasource.remote.response.TypeDetailResponse
import com.decilos.pokedex.domain.model.TypeDetailModel

class TypeDetailMapper : Mapper<TypeDetailResponse, TypeDetailModel> {

    override fun mapFrom(from: TypeDetailResponse): TypeDetailModel {
        return TypeDetailModel(
            name = from.name,
            url = from.url
        )
    }
}
