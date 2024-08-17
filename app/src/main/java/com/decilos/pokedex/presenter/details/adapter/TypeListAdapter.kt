package com.decilos.pokedex.presenter.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decilos.pokedex.databinding.ItemPokemonTypeBinding
import com.decilos.pokedex.domain.model.TypeModel
import com.decilos.pokedex.presenter.details.viewholder.TypeListViewholder

class TypeListAdapter(private val types: List<TypeModel>): RecyclerView.Adapter<TypeListViewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeListViewholder {
        val binding = ItemPokemonTypeBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return TypeListViewholder(binding)
    }

    override fun getItemCount(): Int = types.size

    override fun onBindViewHolder(holder: TypeListViewholder, position: Int) {
        val type = types[position]
        holder.bindData(type)
    }
}
