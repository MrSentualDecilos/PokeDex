package com.decilos.pokedex.domain.usecase

import com.decilos.pokedex.data.PokemonRepository
import com.decilos.pokedex.domain.mapper.ModelListToEntityListMapper
import com.decilos.pokedex.domain.model.PokemonDetailModel
import com.decilos.pokedex.domain.model.PokemonModel
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(
    private val repository: PokemonRepository
) {

    private var didCameFromDB: Boolean = false

    suspend fun getPokemons(limit: Int, offSet: Int) : List<PokemonModel> {
        val pokemonList = repository.getAllPokemonsFromService(limit, offSet)

        return if (pokemonList.isNotEmpty()) {
            repository.clearPokemon()
            pokemonList
        } else {
            didCameFromDB = true
            repository.getAllPokemonFromDataBase()
        }
    }

    suspend fun getPokemonDetail(name: String) : PokemonDetailModel = repository.getPokemonDetailFromService(name)

    suspend fun insertAllPokemonToDB(pokemonList: List<PokemonModel>) {
        if (!didCameFromDB) {
            repository.insertPokemonToDataBase(ModelListToEntityListMapper().mapFrom(pokemonList))
        }
    }
}
