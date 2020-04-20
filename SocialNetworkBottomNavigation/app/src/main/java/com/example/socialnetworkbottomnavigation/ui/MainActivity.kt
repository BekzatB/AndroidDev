package com.example.socialnetworkbottomnavigation.ui

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.socialnetworkbottomnavigation.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.mainActivityToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.navView)
        val navController = Navigation.findNavController(this, R.id.navHostFragment)
        val appConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.likedFragment
            )
        )
        setupActionBarWithNavController(navController, appConfiguration)
        bottomNavigationView.setupWithNavController(navController)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        return
    }
}
