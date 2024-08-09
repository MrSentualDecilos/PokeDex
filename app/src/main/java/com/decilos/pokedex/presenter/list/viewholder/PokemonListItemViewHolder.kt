package com.decilos.pokedex.presenter.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.decilos.pokedex.R
import com.decilos.pokedex.data.datasource.remote.response.PokemonResponse
import com.decilos.pokedex.databinding.ItemPokemonBinding
import com.decilos.pokedex.domain.model.PokemonModel
import com.decilos.pokedex.domain.util.Extensions.capitalizeWord
import com.decilos.pokedex.domain.util.Extensions.loadImage

class PokemonListItemViewHolder(private val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bindData(currentPokemon: PokemonModel) {
        with(binding) {
            pokemonNameTextview.text = currentPokemon.name.capitalizeWord()
            pokemonImageView.loadImage(currentPokemon.detail.sprites.frontSprite)
            when(currentPokemon.detail.types.first().typeDetail.name) {
                "poison" -> pokemonBackground.setBackgroundResource(R.drawable.background_purple_rounded)
                "grass" -> pokemonBackground.setBackgroundResource(R.drawable.background_green_rounded)
                "electric" -> pokemonBackground.setBackgroundResource(R.drawable.background_yellow_rounded)
                "normal" -> pokemonBackground.setBackgroundResource(R.drawable.background_dark_green_rounded)
                "fire" -> pokemonBackground.setBackgroundResource(R.drawable.background_red_rounded)
                "water" -> pokemonBackground.setBackgroundResource(R.drawable.background_blue_rounded)
                "psychic" -> pokemonBackground.setBackgroundResource(R.drawable.background_dark_purple_rounded)
                else -> pokemonBackground.setBackgroundResource(R.drawable.background_dark_green_rounded)
            }
        }
    }
}