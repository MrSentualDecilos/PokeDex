package com.decilos.pokedex.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StatsModel(
    val baseStat: Int?,
    val stat: StatDetailModel
): Parcelable
