package com.decilos.pokedex.data

import com.decilos.pokedex.data.datasource.remote.response.PokemonResponse
import com.decilos.pokedex.domain.model.PokemonDetailModel
import javax.inject.Inject

class PokemonProvider @Inject constructor() {
    var pokemons: List<PokemonResponse> = emptyList()
    var pokemonDetail: PokemonDetailModel = PokemonDetailModel()
}
