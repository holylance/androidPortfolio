package com.example.androidportfolio.viewpager

import android.os.Bundle
import com.example.androidportfolio.R
import com.example.androidportfolio.base.BaseActivity
import kotlinx.android.synthetic.main.activity_first.*

class ViewPagerActivity : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_first)

    val pagerAdapter = TextViewPagerAdapter(this)
    viewPager.adapter = pagerAdapter

    setUp()
  }
}
