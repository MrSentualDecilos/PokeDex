package com.decilos.pokedex.presenter.list.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decilos.pokedex.domain.model.PokemonModel
import com.decilos.pokedex.domain.usecase.GetPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import javax.inject.Inject

const val LIMIT = 100
const val OFFSET = 0

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonUseCase: GetPokemonUseCase
) : ViewModel() {
    val pokemonList = MutableLiveData<List<PokemonModel>>()
    val isLoading = MutableLiveData<Boolean>()

    fun getPokemonList() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getPokemonUseCase.getPokemons(LIMIT, OFFSET)
            if (result.isNotEmpty()) {
                result.map { pokemon ->
                    async {
                        getPokemonUseCase.getPokemonDetail(pokemon.name).let { detail ->
                            pokemon.detail = detail
                        }
                    }
                }.awaitAll()
                isLoading.postValue(false)
                getPokemonUseCase.insertAllPokemonToDB(result)
                pokemonList.postValue(result)
            }
        }
    }
}
