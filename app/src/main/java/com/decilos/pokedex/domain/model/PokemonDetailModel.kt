package com.decilos.pokedex.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonDetailModel(
    val id: Int = 0,
    val height: Int = 0,
    val weight: Int = 0,
    val name: String = "",
    val order: String = "",
    val sprites: SpriteModel = SpriteModel(),
    val stats: List<StatsModel> = emptyList(),
    val types: List<TypeModel> = emptyList(),
    val abilities: List<AbilitiesModel> = emptyList()
): Parcelable
