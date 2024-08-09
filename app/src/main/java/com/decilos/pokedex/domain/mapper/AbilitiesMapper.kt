package com.decilos.pokedex.domain.mapper

import com.decilos.pokedex.core.common.Mapper
import com.decilos.pokedex.data.datasource.remote.response.AbilitiesResponse
import com.decilos.pokedex.domain.model.AbilitiesModel

class AbilitiesMapper : Mapper<AbilitiesResponse, AbilitiesModel> {

    override fun mapFrom(from: AbilitiesResponse): AbilitiesModel {
        return AbilitiesModel(
            isHidden = from.isHidden,
            slot = from.slot,
            ability = AbilityMapper().mapFrom(from.ability)
        )
    }
}
