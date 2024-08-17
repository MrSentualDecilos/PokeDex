package com.decilos.pokedex.presenter.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.decilos.pokedex.R
import com.decilos.pokedex.databinding.FragmentPokemonDetailBinding
import com.decilos.pokedex.domain.model.PokemonDetailModel
import com.decilos.pokedex.domain.util.Extensions.capitalizeWord
import com.decilos.pokedex.domain.util.Extensions.loadImage
import com.decilos.pokedex.presenter.details.adapter.TypeListAdapter
import com.decilos.pokedex.presenter.details.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class PokemonDetailFragment : Fragment() {
    private lateinit var binding: FragmentPokemonDetailBinding
    private lateinit var adapter: TypeListAdapter

    private lateinit var pokemonDetail: PokemonDetailModel
    private val pokemonDetailNavArgs: PokemonDetailFragmentArgs by navArgs()

    private val tabsArray by lazy {
        resources.getStringArray(R.array.pokemon_detail_tabs)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPokemonDetailBinding.inflate(layoutInflater)
        pokemonDetailNavArgs.pokemonDetailModel?.let {
            pokemonDetail = it
        } ?: PokemonDetailModel()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    private fun setUpViews() {
        binding.apply {
            pokemonDetailImage.loadImage(pokemonDetail.sprites.frontSprite)
            pokemonDetailName.text = pokemonDetail.name.capitalizeWord()
            pokemonDetailOrder.text = getString(R.string.pokemon_order_number, pokemonDetail.order)
            pokemonDetail.types.first().typeDetail.name?.let { setTypeBackground(it) }
            setUpAdapter()
            setViewPagerAdapter()
        }
    }

    private fun setUpAdapter() {
        adapter = TypeListAdapter(pokemonDetail.types)
        binding.apply {
            pokemonDetailTypesRecyclerview.setHasFixedSize(true)
            pokemonDetailTypesRecyclerview.adapter = adapter
        }
    }

    private fun setViewPagerAdapter() {
        val adapter = activity?.supportFragmentManager?.let {
            ViewPagerAdapter(
                it,
                lifecycle
            )
        }
        adapter?.pageList?.apply {
            add(GeneralInfoFragment(pokemonDetail))
            add(StatsFragment(pokemonDetail.stats))
        }
        binding.pokemonDetailViewPager.apply {
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            setAdapter(adapter)
        }
        setPageListener()
    }

    private fun setPageListener() {
        TabLayoutMediator(
            binding.detailInfoTabLayout,
            binding.pokemonDetailViewPager
        ) { tab, position ->
            tab.text = tabsArray[position].toString()
        }.attach()
    }

    private fun setTypeBackground(type: String) {
        binding.apply {
            when(type) {
                resources.getString(R.string.type_poison) -> pokemonDetailTypeBackground.setImageResource(R.drawable.poison_type_background)
                resources.getString(R.string.type_grass) -> pokemonDetailTypeBackground.setImageResource(R.drawable.grass_type_background)
                resources.getString(R.string.type_electric) -> pokemonDetailTypeBackground.setImageResource(R.drawable.electric_type_background)
                resources.getString(R.string.type_normal) -> pokemonDetailTypeBackground.setImageResource(R.drawable.normal_type_background)
                resources.getString(R.string.type_fire) -> pokemonDetailTypeBackground.setImageResource(R.drawable.fire_type_background)
                resources.getString(R.string.type_water) -> pokemonDetailTypeBackground.setImageResource(R.drawable.water_type_background)
                resources.getString(R.string.type_psychic) -> pokemonDetailTypeBackground.setImageResource(R.drawable.psychic_type_background)
                resources.getString(R.string.type_fighting) -> pokemonDetailTypeBackground.setImageResource(R.drawable.fighting_type_background)
                resources.getString(R.string.type_rock) -> pokemonDetailTypeBackground.setImageResource(R.drawable.rock_type_background)
                resources.getString(R.string.type_ghost) -> pokemonDetailTypeBackground.setImageResource(R.drawable.ghost_type_background)
                else -> pokemonDetailTypeBackground.setImageResource(R.drawable.normal_type_background)
            }
        }
    }
}
