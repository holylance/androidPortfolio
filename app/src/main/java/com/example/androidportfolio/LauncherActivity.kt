package com.example.androidportfolio

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.content.Intent
import kotlinx.android.synthetic.main.activity_launcher.*

class LauncherActivity : AppCompatActivity() {
  companion object {
    fun newIntent(context: Context): Intent {
      return Intent(context, RecycleViewBasicActivity::class.java)
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_launcher)

    launcherLayout.setOnTouchListener(object : OnTouchListener {
      override fun onTouch(v: View, event: MotionEvent): Boolean {
        when (event?.action) {
          MotionEvent.ACTION_DOWN -> {
              val intent = LauncherActivity.newIntent(v.context)
              startActivity(intent)
            }
        }
        return v?.onTouchEvent(event)
      }
    })
  }
}
