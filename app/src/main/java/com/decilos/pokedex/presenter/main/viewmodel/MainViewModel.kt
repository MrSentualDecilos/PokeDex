package com.decilos.pokedex.presenter.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.decilos.pokedex.domain.model.PokemonModel

class MainViewModel : ViewModel() {

    val pokemonList = MutableLiveData<List<PokemonModel>>()

    fun getPokemonList() {
    }
}
