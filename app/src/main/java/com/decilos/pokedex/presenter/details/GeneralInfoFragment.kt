package com.decilos.pokedex.presenter.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.decilos.pokedex.R
import com.decilos.pokedex.databinding.FragmentGeneralInfoBinding
import com.decilos.pokedex.domain.model.PokemonDetailModel
import com.decilos.pokedex.domain.util.Extensions.capitalizeWord
import com.decilos.pokedex.domain.util.Extensions.convertFeetToMeters
import com.decilos.pokedex.domain.util.Extensions.convertPoundsToKilograms

class GeneralInfoFragment(val pokemonDetail: PokemonDetailModel): Fragment() {
    private lateinit var binding: FragmentGeneralInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGeneralInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    private fun setUpViews() {
        binding.apply {
            weightTextview.text = getString(R.string.pokemon_weight, pokemonDetail.weight.convertPoundsToKilograms().toString())
            heightTextview.text = getString(R.string.pokemon_height, pokemonDetail.height.convertFeetToMeters().toString())
            abilityTextview.text = pokemonDetail.abilities.first().ability.name?.capitalizeWord()
        }
    }
}
