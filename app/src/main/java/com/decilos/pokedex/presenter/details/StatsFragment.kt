package com.decilos.pokedex.presenter.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.decilos.pokedex.R
import com.decilos.pokedex.databinding.FragmentStatsBinding
import com.decilos.pokedex.domain.model.StatsModel

class StatsFragment(private val stats: List<StatsModel>): Fragment() {
    private lateinit var binding: FragmentStatsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStatsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    private fun setUpViews() {
        binding.apply {
            stats.map {
                when(it.stat.name) {
                    getString(R.string.health).lowercase() -> {
                        healthTextview.text = it.baseStat.toString()
                    }
                    getString(R.string.attack).lowercase() -> {
                        attackTextview.text = it.baseStat.toString()
                    }
                    getString(R.string.defense).lowercase() -> {
                        defenseTextview.text = it.baseStat.toString()
                    }
                }
            }
        }
    }
}
