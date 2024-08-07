package com.decilos.pokedex.presenter.list.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.decilos.pokedex.domain.model.PokemonModel

class PokemonListViewModel : ViewModel() {
    val pokemonList = MutableLiveData<List<PokemonModel>>()

    fun getPokemonList() {
    }
}