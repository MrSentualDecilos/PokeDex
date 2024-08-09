package com.decilos.pokedex.domain.mapper

import com.decilos.pokedex.core.common.Mapper
import com.decilos.pokedex.data.datasource.remote.response.AbilityResponse
import com.decilos.pokedex.domain.model.AbilityModel

class AbilityMapper : Mapper<AbilityResponse, AbilityModel> {

    override fun mapFrom(from: AbilityResponse): AbilityModel {
        return AbilityModel(
            name = from.name
        )
    }
}
