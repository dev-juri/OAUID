package com.group16.oauid.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.group16.oauid.R
import com.group16.oauid.databinding.ActivityHomeBinding
import com.group16.oauid.viewBinding

class HomeActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityHomeBinding::inflate)
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.homeFragmentNavHost) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNav.setupWithNavController(navController)

    }
}