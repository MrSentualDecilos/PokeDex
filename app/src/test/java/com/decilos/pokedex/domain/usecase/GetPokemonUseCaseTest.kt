package com.decilos.pokedex.domain.usecase

import com.decilos.pokedex.data.PokemonRepository
import com.decilos.pokedex.domain.model.PokemonDetailModel
import com.decilos.pokedex.domain.model.PokemonModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetPokemonUseCaseTest {

    @RelaxedMockK
    private lateinit var repository: PokemonRepository

    lateinit var getPokemonUseCase: GetPokemonUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getPokemonUseCase = GetPokemonUseCase(repository)
    }

    @Test
    fun `when api fail to return value then get values from data base`() = runBlocking {
        //When
        coEvery {
            repository.getAllPokemonsFromService(100, 0)
        } returns emptyList()

        //Given
        getPokemonUseCase.getPokemons(100, 0)

        //Then
        coVerify(exactly = 1) { repository.getAllPokemonFromDataBase() }
    }

    @Test
    fun `when api returns values then get values from service`() = runBlocking {
        //When
        val list = listOf(
            PokemonModel(
                "charmander",
                "www.pokeapi.com",
                PokemonDetailModel()
            )
        )
        coEvery {
            repository.getAllPokemonsFromService(any(), any())
        }returns list

        //Given
        val response = getPokemonUseCase.getPokemons(100, 0)

        //Then
        coVerify(exactly = 1) {repository.getAllPokemonsFromService(any(), any())}
        coVerify(exactly = 1) {repository.clearPokemon()}
        coVerify(exactly = 0) {repository.getAllPokemonFromDataBase()}
        assert(list == response)
    }
}
