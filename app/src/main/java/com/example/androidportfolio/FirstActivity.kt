package com.example.androidportfolio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_first)

    val pagerAdapter = TextViewPagerAdapter(this)
    viewPager.setAdapter(pagerAdapter)
  }
}
