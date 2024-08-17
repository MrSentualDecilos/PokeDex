package com.decilos.pokedex.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AbilitiesModel(
    val isHidden: Boolean,
    val slot: Int?,
    val ability: AbilityModel
): Parcelable
