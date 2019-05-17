package com.example.androidportfolio

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.View.OnTouchListener
import android.view.*
import com.example.androidportfolio.base.BaseActivity
import kotlinx.android.synthetic.main.activity_launcher.*

class LauncherActivity : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_launcher)

    // toach any screen go to total menu activity.
    launcherLayout.setOnTouchListener(object : OnTouchListener {
      override fun onTouch(v: View, event: MotionEvent): Boolean {
        //when (event?.action) {
        //  MotionEvent.ACTION_DOWN -> {
        //      val intent = Intent(v.context, RecycleViewBasicActivity::class.java)
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

    setUp()
  }
}
