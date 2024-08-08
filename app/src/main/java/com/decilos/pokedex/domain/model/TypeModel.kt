package com.decilos.pokedex.domain.model

import com.google.gson.annotations.SerializedName

data class TypeModel(
    val slot: Int,
    @SerializedName("type")val TypeDetail: TypeDetailModel
)
