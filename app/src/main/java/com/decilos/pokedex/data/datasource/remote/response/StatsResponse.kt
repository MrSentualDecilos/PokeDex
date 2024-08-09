package com.decilos.pokedex.data.datasource.remote.response

import com.google.gson.annotations.SerializedName

data class StatsResponse(
    @SerializedName("base_stat") val baseStat: Int?,
    @SerializedName("stat") val stat: StatDetailResponse
)
