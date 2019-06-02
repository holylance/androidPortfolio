package com.example.androidportfolio.myCareers

import android.os.Bundle
import com.example.androidportfolio.R
import com.example.androidportfolio.base.BaseActivity
import kotlinx.android.synthetic.main.activity_view_pager.*

class MyCareersActivity : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_view_pager)

    val pagerAdapter = MyCareersViewPagerAdapter(this)
    viewPager.adapter = pagerAdapter

    setUp()
  }
}
