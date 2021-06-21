package com.example.androidportfolio.base

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseActivity(@LayoutRes layout: Int) : AppCompatActivity(layout) {
    protected open val activityOptions = ActivityOptions()

    private val compositeDisposable = CompositeDisposable()

    protected fun bind(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (activityOptions.fullscreen) {
            // Activities use fullscreen mode to allow Fragments occasionally draw under the status bar,
            // and to make transitions between these fullscreen Fragments and normal Fragments fluid.
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }

        // Change statusbar icons between day/night modes
        window.decorView.apply {
            val mode = resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK)

            systemUiVisibility = when (mode == Configuration.UI_MODE_NIGHT_YES) {
                true -> systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
                false -> systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }

        super.onCreate(savedInstanceState)

        @SuppressLint("SourceLockedOrientationActivity")
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    protected data class ActivityOptions(
        val fullscreen: Boolean = true
    )
}
