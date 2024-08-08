package com.decilos.pokedex.domain.model

import com.google.gson.annotations.SerializedName

data class SpriteModel(
    @SerializedName("back_default") val backSprite: String = "",
    @SerializedName("front_default") val frontSprite: String = "",
    @SerializedName("back_shiny") val backShiningSprite: String = "",
    @SerializedName("front_shiny") val frontShiningSprite: String = ""
)
