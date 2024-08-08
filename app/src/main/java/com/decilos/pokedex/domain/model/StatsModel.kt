package com.decilos.pokedex.domain.model

import com.google.gson.annotations.SerializedName

data class StatsModel(
    @SerializedName("base_stat") val baseStat: Int?,
    @SerializedName("stat") val stat: StatDetailModel
)
