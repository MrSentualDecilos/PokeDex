package com.decilos.pokedex.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StatDetailModel(
    val name: String?,
    val url: String?
): Parcelable
