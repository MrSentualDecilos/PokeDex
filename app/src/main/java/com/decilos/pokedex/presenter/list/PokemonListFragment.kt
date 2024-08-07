package com.decilos.pokedex.presenter.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.decilos.pokedex.databinding.FragmentPokemonListBinding
import com.decilos.pokedex.domain.model.PokemonModel
import com.decilos.pokedex.presenter.list.viewmodel.PokemonListViewModel

const val SPAN_COUNT = 1

class PokemonListFragment : Fragment() {
    private lateinit var binding: FragmentPokemonListBinding
    private val viewModel: PokemonListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpViews()
        setObserver()
        viewModel.getPokemonList()
    }

    private fun setUpViews() {
        binding.apply {
            mainPokemonRecyclerview.layoutManager = GridLayoutManager(requireContext(), SPAN_COUNT, GridLayoutManager.VERTICAL, false)
        }
    }

    private fun setObserver() {
        viewModel.pokemonList.observe(viewLifecycleOwner) {
            setListToView(it)
        }
    }

    private fun setListToView(list: List<PokemonModel>) {
        val adapter
    }
}
