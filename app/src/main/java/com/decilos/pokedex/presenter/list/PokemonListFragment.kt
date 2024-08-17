package com.decilos.pokedex.presenter.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.decilos.pokedex.R
import com.decilos.pokedex.databinding.FragmentPokemonListBinding
import com.decilos.pokedex.domain.model.PokemonModel
import com.decilos.pokedex.presenter.list.adapters.PokemonListAdapter
import com.decilos.pokedex.presenter.list.viewmodel.PokemonListViewModel
import dagger.hilt.android.AndroidEntryPoint

const val SPAN_COUNT = 3

@AndroidEntryPoint
class PokemonListFragment : Fragment() {
    private lateinit var binding: FragmentPokemonListBinding
    private lateinit var adapter: PokemonListAdapter
    private val viewModel: PokemonListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPokemonListBinding.inflate(layoutInflater)
        viewModel.getPokemonList()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
        setObserver()
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

        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.loader.isVisible = it
        }
    }

    private fun setListToView(list: List<PokemonModel>) {
        adapter = PokemonListAdapter(list) {
            PokemonListFragmentDirections.actionFromPokemonlistToPokemondetail(it).let { direction ->
                findNavController().navigate(direction)
            }
        }
        binding.apply {
            mainPokemonRecyclerview.setHasFixedSize(true)
            mainPokemonRecyclerview.adapter = adapter
        }
    }
}
