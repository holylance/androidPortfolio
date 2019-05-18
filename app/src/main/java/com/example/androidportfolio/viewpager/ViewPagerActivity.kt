package com.example.androidportfolio.viewpager

import android.os.Bundle
import com.example.androidportfolio.R
import com.example.androidportfolio.base.BaseActivity
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_view_pager)

    val pagerAdapter = TextViewPagerAdapter(this)
    viewPager.adapter = pagerAdapter

    setUp()
  }
}
