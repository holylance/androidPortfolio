package com.example.androidportfolio

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnTouchListener
import android.content.Intent
import android.support.constraint.ConstraintLayout
import android.view.*
import kotlinx.android.synthetic.main.activity_launcher.*
import com.example.androidportfolio.recycleview.RecycleViewBasicActivity
import com.example.androidportfolio.viewpager.ViewPagerActivity

class LauncherActivity : AppCompatActivity() {
  companion object {
    fun newIntent(context: Context): Intent {
      return Intent(context, RecycleViewBasicActivity::class.java)
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_launcher)

    // toach any screen go to total menu activity.
    launcherLayout.setOnTouchListener(object : OnTouchListener {
      override fun onTouch(v: View, event: MotionEvent): Boolean {
        //when (event?.action) {
        //  MotionEvent.ACTION_DOWN -> {
        //      val intent = LauncherActivity.newIntent(v.context)
        //      startActivity(intent)
        //    }
        //}
        return v.onTouchEvent(event)
      }
    })

    // get status bar height.
    val resId = resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resId > 0) {
      val statusBarHeight = resources.getDimensionPixelSize(resId)
      val parameter = app_toolbar.layoutParams as ConstraintLayout.LayoutParams

      // add top margin, because the status bar and a new tool bar are overlapped.
      parameter.setMargins(
        parameter.leftMargin,
        statusBarHeight,
        parameter.rightMargin,
        parameter.bottomMargin
      ) // left, top, right, bottom
      app_toolbar.layoutParams = parameter
    }

    // set tool bar.
    setSupportActionBar(app_toolbar)
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.appbar_action, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when(item.itemId) {
      R.id.action_home -> startActivity(Intent(this, ViewPagerActivity::class.java))
      R.id.action_recycleview -> startActivity(Intent(this, RecycleViewBasicActivity::class.java))
    }
    return true
  }
}
