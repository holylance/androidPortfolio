package com.example.androidportfolio

import android.content.Intent
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.example.androidportfolio.base.BaseActivity
import com.example.androidportfolio.databinding.ActivityHomeBinding
import com.example.androidportfolio.util.viewBinding

class HomeActivity : BaseActivity(R.layout.activity_home) {

    private val binding by viewBinding(ActivityHomeBinding::bind)
    private lateinit var navController: LiveData<NavController>

    private val fullscreenListener = NavController.OnDestinationChangedListener { _, _, arguments ->
        setFullscreen(arguments?.getBoolean("fullscreen") == true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        if (navController.value?.navigateUp() != true) super.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.value?.navigateUp() == true || super.onSupportNavigateUp()
    }

    private fun setupBottomNavigationBar() {
        // TODO: in navigation task
    }

    private fun getIntentForDeeplink(): Intent {
        val value = Intent(intent)
        intent.data = null
        return value
    }

    private fun setupFullscreenHandler(navController: NavController) {
        navController.removeOnDestinationChangedListener(fullscreenListener)
        navController.addOnDestinationChangedListener(fullscreenListener)
    }

    private fun setFullscreen(fullscreen: Boolean) {
        binding.navView.isVisible = !fullscreen
    }
}
