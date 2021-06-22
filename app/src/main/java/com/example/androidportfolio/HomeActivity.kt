package com.example.androidportfolio

import android.content.Intent
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.androidportfolio.base.BaseActivity

class HomeActivity : BaseActivity(R.layout.activity_home) {

    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navController = supportFragmentManager.findFragmentById(R.id.nav_host_home)
            ?.findNavController()
        navController?.setGraph(R.navigation.lobby_nav_graph)

        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        // BottomNavigationBar can be set up after it has restored its instance state
        setupBottomNavigationBar()
    }

    override fun onBackPressed() {
        if (navController?.navigateUp() == false) super.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController?.navigateUp() == true || super.onSupportNavigateUp()
    }

    private fun setupBottomNavigationBar() {
        // TODO: in navigation task
    }

    private fun getIntentForDeeplink(): Intent {
        val value = Intent(intent)
        intent.data = null
        return value
    }
}
