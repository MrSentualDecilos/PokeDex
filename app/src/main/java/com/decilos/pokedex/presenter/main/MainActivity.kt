package com.decilos.pokedex.presenter.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.decilos.pokedex.R
import com.decilos.pokedex.databinding.ActivityMainBinding
import com.decilos.pokedex.presenter.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    private val toolbar by lazy {
        binding.mainToolbar.toolbar
    }

    private val toolbarTitle by lazy {
        binding.mainToolbar.toolbarTitle
    }


    private val navHost by lazy {
        supportFragmentManager.findFragmentById(R.id.main_nav_fragment) as NavHostFragment
    }

    private val navController by lazy {
        navHost.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitleToolbar(getString(R.string.app_name))
    }

    private fun setTitleToolbar(title: String) {
        toolbarTitle.text = title
    }
}
