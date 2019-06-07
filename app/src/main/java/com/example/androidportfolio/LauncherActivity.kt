package com.example.androidportfolio

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View.OnTouchListener
import android.view.*
import com.example.androidportfolio.lobby.LobbyActivity
import com.example.androidportfolio.staggeredgridcolors.StaggeredGridColorsActivity
import kotlinx.android.synthetic.main.activity_launcher.*

class LauncherActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_launcher)

    // toach any screen go to total menu activity.
    launcherLayout.setOnTouchListener(object : OnTouchListener {
      override fun onTouch(v: View, event: MotionEvent): Boolean {
        when (event.action) {
          MotionEvent.ACTION_DOWN -> {
              val intent = Intent(v.context, StaggeredGridColorsActivity::class.java)
              startActivity(intent)
            }
        }
        return v.onTouchEvent(event)
      }
    })
  }
}
