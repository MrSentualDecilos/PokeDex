package com.decilos.pokedex.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TypeModel(
    val slot: Int,
    val typeDetail: TypeDetailModel
): Parcelable
