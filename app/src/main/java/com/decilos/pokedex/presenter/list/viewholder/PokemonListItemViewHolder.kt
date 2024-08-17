package com.decilos.pokedex.presenter.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.decilos.pokedex.R
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
                root.resources.getString(R.string.type_poison) -> pokemonBackground.setBackgroundResource(R.drawable.background_purple_rounded)
                root.resources.getString(R.string.type_grass) -> pokemonBackground.setBackgroundResource(R.drawable.background_green_rounded)
                root.resources.getString(R.string.type_electric) -> pokemonBackground.setBackgroundResource(R.drawable.background_yellow_rounded)
                root.resources.getString(R.string.type_normal) -> pokemonBackground.setBackgroundResource(R.drawable.background_dark_green_rounded)
                root.resources.getString(R.string.type_fire) -> pokemonBackground.setBackgroundResource(R.drawable.background_red_rounded)
                root.resources.getString(R.string.type_water) -> pokemonBackground.setBackgroundResource(R.drawable.background_blue_rounded)
                root.resources.getString(R.string.type_psychic) -> pokemonBackground.setBackgroundResource(R.drawable.background_dark_purple_rounded)
                root.resources.getString(R.string.type_rock) -> pokemonBackground.setBackgroundResource(R.drawable.background_rock_rounded)
                root.resources.getString(R.string.type_fighting) -> pokemonBackground.setBackgroundResource(R.drawable.background_pink_rounded)
                root.resources.getString(R.string.type_ghost) -> pokemonBackground.setBackgroundResource(R.drawable.background_ghost_rounded)
                else -> pokemonBackground.setBackgroundResource(R.drawable.background_dark_green_rounded)
            }
        }
    }
}