package com.decilos.pokedex.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SpriteModel(
    val backSprite: String = "",
    val frontSprite: String = "",
    val backShiningSprite: String = "",
    val frontShiningSprite: String = ""
): Parcelable
