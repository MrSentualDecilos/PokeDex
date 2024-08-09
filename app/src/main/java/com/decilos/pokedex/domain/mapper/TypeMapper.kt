package com.decilos.pokedex.domain.mapper

import com.decilos.pokedex.core.common.Mapper
import com.decilos.pokedex.data.datasource.remote.response.TypeResponse
import com.decilos.pokedex.domain.model.TypeModel

class TypeMapper : Mapper<TypeResponse, TypeModel> {

    override fun mapFrom(from: TypeResponse): TypeModel {
        return TypeModel(
            slot = from.slot,
            typeDetail = TypeDetailMapper().mapFrom(from.typeDetail)
        )
    }
}