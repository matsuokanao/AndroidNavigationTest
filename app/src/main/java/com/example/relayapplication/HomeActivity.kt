package com.example.relayapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.relayapplication.application.ApplicationFragment
import com.example.relayapplication.home.HomeFragment
import com.example.relayapplication.manager.ManagerFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*

enum class ProviderType {
    BASIC
}

class HomeActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Load first fragment by default
        loadFragment(HomeFragment())

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when{
                menuItem.itemId == R.id.navigationHome -> {
                    loadFragment(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                menuItem.itemId == R.id.navigationApplication -> {
                    loadFragment(ApplicationFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                menuItem.itemId == R.id.navigationManager -> {
                    loadFragment(ManagerFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                 }
             }
        }
    }
    private fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().also{fragmentTransaction ->
            fragmentTransaction.replace(R.id.fragmentContainer, fragment)
            fragmentTransaction.commit()
        }
    }
}




