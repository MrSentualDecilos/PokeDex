package com.decilos.pokedex.presenter.details.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.decilos.pokedex.R
import com.decilos.pokedex.databinding.ItemPokemonTypeBinding
import com.decilos.pokedex.domain.model.TypeModel

class TypeListViewholder(private val binding: ItemPokemonTypeBinding): RecyclerView.ViewHolder(binding.root) {
    fun bindData(type: TypeModel) {
        with(binding) {
            itemTypeListName.text = type.typeDetail.name
            when(type.typeDetail.name) {
                root.resources.getString(R.string.type_poison) -> itemTypeListName.setBackgroundResource(R.drawable.background_type_list_purple)
                root.resources.getString(R.string.type_grass) -> itemTypeListName.setBackgroundResource(R.drawable.background_type_list_green)
                root.resources.getString(R.string.type_electric) -> itemTypeListName.setBackgroundResource(R.drawable.background_type_list_yellow)
                root.resources.getString(R.string.type_normal) -> itemTypeListName.setBackgroundResource(R.drawable.background_type_list_dark_green)
                root.resources.getString(R.string.type_fire) -> itemTypeListName.setBackgroundResource(R.drawable.background_type_list_red)
                root.resources.getString(R.string.type_water) -> itemTypeListName.setBackgroundResource(R.drawable.background_type_list_blue)
                root.resources.getString(R.string.type_psychic) -> itemTypeListName.setBackgroundResource(R.drawable.background_type_list_psycic)
                root.resources.getString(R.string.type_fighting) -> itemTypeListName.setBackgroundResource(R.drawable.background_type_list_fighting)
                root.resources.getString(R.string.type_rock) -> itemTypeListName.setBackgroundResource(R.drawable.background_type_list_rock)
                root.resources.getString(R.string.type_ghost) -> itemTypeListName.setBackgroundResource(R.drawable.background_type_list_ghost)
                else -> itemTypeListName.setBackgroundResource(R.drawable.background_type_list_dark_green)
            }
        }
    }
}
