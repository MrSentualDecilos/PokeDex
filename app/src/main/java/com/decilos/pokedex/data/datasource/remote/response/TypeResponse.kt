package com.decilos.pokedex.data.datasource.remote.response

import com.google.gson.annotations.SerializedName

data class TypeResponse(
    val slot: Int,
    @SerializedName("type")val typeDetail: TypeDetailResponse
)
