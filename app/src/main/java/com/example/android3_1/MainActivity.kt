package com.example.android3_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.android3_1.ui.data.PreferensHelper

class MainActivity : AppCompatActivity() {
    private val preferensHelper: PreferensHelper by lazy {
        PreferensHelper(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation(savedInstanceState)
    }

    private fun setupNavigation(savedInstanceState: Bundle?) {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fcv_main_activity) as NavHostFragment
        val navController = navHostFragment.navController
        if (savedInstanceState == null) {
            val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
            if (!preferensHelper.register) {
                navGraph.setStartDestination(R.id.regisrationFragment)
                navController.graph = navGraph
            }
        }
    }
}
