package com.decilos.pokedex.presenter.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.fragment.NavHostFragment
import com.decilos.pokedex.R
import com.decilos.pokedex.databinding.ActivityMainBinding
import com.decilos.pokedex.presenter.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

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
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !viewModel.isReady.value
            }
        }
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitleToolbar(getString(R.string.app_name))
        setUpNavControllerListener()
    }

    private fun setTitleToolbar(title: String) {
        toolbarTitle.text = title
    }

    private fun setUpNavControllerListener() {
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id) {
                R.id.pokemon_list_fragment -> {
                    setTitleToolbar(getString(R.string.app_name))
                }
                R.id.pokemon_detail_fragment -> {
                    setTitleToolbar("")
                }
            }
        }
    }
}
