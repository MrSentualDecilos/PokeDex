package com.decilos.pokedex.presenter.list.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.decilos.pokedex.domain.model.PokemonDetailModel
import com.decilos.pokedex.domain.model.PokemonModel
import com.decilos.pokedex.domain.model.SpriteModel
import com.decilos.pokedex.domain.usecase.GetPokemonUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class PokemonListViewModelTest {

    @RelaxedMockK
    private lateinit var getPokemonUseCase: GetPokemonUseCase

    lateinit var pokemonListViewModel: PokemonListViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        pokemonListViewModel = PokemonListViewModel(getPokemonUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when viewmodel get function is called, return all pokemon and set values`() = runTest {
        //Given
        val list = listOf(
            PokemonModel(
                "charmander",
                "www.pokeapi.com",
                PokemonDetailModel()
            ),
            PokemonModel(
                "charmander",
                "www.pokeapi.com",
                PokemonDetailModel()
            )
        )

        coEvery { getPokemonUseCase.getPokemons(any(), any()) } returns list

        //When
        pokemonListViewModel.getPokemonList()

        //Then
        assert(pokemonListViewModel.pokemonList.value == list)
    }

    @Test
    fun `when viewmodel get function is called, return details`() = runTest {
        //Given
        val list = listOf(
            PokemonModel(
                "charmander",
                "www.pokeapi.com",
                PokemonDetailModel()
            ),
            PokemonModel(
                "charmander",
                "www.pokeapi.com",
                PokemonDetailModel()
            )
        )

        val detail = PokemonDetailModel(
            1,
            2,
            3,
            "charmander",
            order = "",
            SpriteModel()
        )

        coEvery { getPokemonUseCase.getPokemons(any(), any()) } returns list
        coEvery { getPokemonUseCase.getPokemonDetail(any()) } returns detail

        //When
        pokemonListViewModel.getPokemonList()

        //Then
        assert(pokemonListViewModel.pokemonList.value?.first()?.detail == detail)
    }
}
