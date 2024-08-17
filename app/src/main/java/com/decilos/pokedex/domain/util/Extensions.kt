package com.decilos.pokedex.domain.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import java.util.Locale
import kotlin.math.roundToInt

const val KILOGRAM_IN_POUNDS_UNIT = 2.20462
const val METERS_IN_FEETS_UNIT = 0.3048
object Extensions {
    fun String.capitalizeWord(): String {
        return this.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(
                Locale("en", "US")
            ) else it.toString()
        }
    }

    fun ImageView.loadImage(url: String) {
        if (url.isNotEmpty()) {
            Glide.with(this.context).load(url).into(this)
        }
    }

    fun Int.convertPoundsToKilograms(): Int {
        return (this / KILOGRAM_IN_POUNDS_UNIT).roundToInt()
    }

    fun Int.convertFeetToMeters(): Int {
        return (this * METERS_IN_FEETS_UNIT).roundToInt()
    }
}
