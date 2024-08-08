package com.decilos.pokedex.domain.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import java.util.Locale

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
}
