package com.decilos.pokedex.domain.mapper

import com.decilos.pokedex.core.common.Mapper
import com.decilos.pokedex.data.datasource.remote.response.SpritesResponse
import com.decilos.pokedex.domain.model.SpriteModel

class SpritesMapper : Mapper<SpritesResponse, SpriteModel> {
    override fun mapFrom(from: SpritesResponse): SpriteModel {
        return SpriteModel(
            frontSprite = from.frontSprite,
            backSprite = from.backSprite,
            frontShiningSprite = from.frontShiningSprite,
            backShiningSprite = from.backShiningSprite
        )
    }
}
