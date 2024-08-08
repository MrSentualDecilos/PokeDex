package com.decilos.pokedex.presenter.list.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decilos.pokedex.R
import com.decilos.pokedex.data.datasource.remote.response.PokemonResponse
import com.decilos.pokedex.databinding.ItemPokemonBinding
import com.decilos.pokedex.domain.util.Extensions.capitalizeWord
import com.decilos.pokedex.domain.util.Extensions.loadImage
import com.decilos.pokedex.presenter.list.viewholder.PokemonListItemViewHolder

class PokemonListAdapter(val pokemons: List<PokemonResponse>) : RecyclerView.Adapter<PokemonListItemViewHolder>() {
    private lateinit var binding: ItemPokemonBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = ItemPokemonBinding.inflate(layoutInflater, parent, false)
        return PokemonListItemViewHolder(binding.root)
    }

    override fun getItemCount(): Int = pokemons.size

    override fun onBindViewHolder(holder: PokemonListItemViewHolder, position: Int) {
        val currentPokemon = pokemons[position]
        with(binding) {
            pokemonNameTextview.text = currentPokemon.name.capitalizeWord()
            pokemonImageView.loadImage(currentPokemon.detail.sprites.frontSprite)
            when(currentPokemon.detail.types.first().TypeDetail.name) {
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
