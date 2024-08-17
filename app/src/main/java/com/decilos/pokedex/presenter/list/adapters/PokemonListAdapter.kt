package com.decilos.pokedex.presenter.list.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decilos.pokedex.data.datasource.remote.response.PokemonResponse
import com.decilos.pokedex.databinding.ItemPokemonBinding
import com.decilos.pokedex.domain.model.PokemonDetailModel
import com.decilos.pokedex.domain.model.PokemonModel
import com.decilos.pokedex.presenter.list.viewholder.PokemonListItemViewHolder

class PokemonListAdapter(
    private val pokemons: List<PokemonModel>,
    private val onItemClicked: (PokemonDetailModel) -> Unit
) : RecyclerView.Adapter<PokemonListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListItemViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return PokemonListItemViewHolder(binding)
    }

    override fun getItemCount(): Int = pokemons.size

    override fun onBindViewHolder(holder: PokemonListItemViewHolder, position: Int) {
        val currentPokemon = pokemons[position]
        holder.bindData(currentPokemon)
        holder.itemView.rootView.setOnClickListener {
            onItemClicked(currentPokemon.detail)
        }
    }
}
