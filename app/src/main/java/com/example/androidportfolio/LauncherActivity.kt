package com.example.androidportfolio

import android.content.Intent
import android.os.Bundle
import com.example.androidportfolio.base.BaseActivity
import com.example.androidportfolio.databinding.ActivityLauncherBinding
import com.example.androidportfolio.util.viewBinding

class LauncherActivity : BaseActivity(R.layout.activity_launcher) {

    private val binding by viewBinding(ActivityLauncherBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // toach any screen go to total menu activity.
        binding.launcherLayout.setOnClickListener {
            val intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}
