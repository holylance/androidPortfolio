package com.example.androidportfolio.viewpager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.androidportfolio.R
import kotlinx.android.synthetic.main.activity_first.*

class ViewPagerActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_first)

    val pagerAdapter = TextViewPagerAdapter(this)
    viewPager.adapter = pagerAdapter
  }
}
