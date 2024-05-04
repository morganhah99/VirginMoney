package com.example.virginmoney

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.virginmoney.databinding.ActivityMainBinding
import com.example.virginmoney.ui.list.people.PeopleFragment
import com.example.virginmoney.ui.list.rooms.RoomsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.people -> navController.navigate(R.id.peopleFragment)
                R.id.rooms -> navController.navigate(R.id.roomsFragment)
                else -> {}

            }
            true
        }

    }


}