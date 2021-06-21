package com.example.androidportfolio.myCareers

import android.os.Bundle
import com.example.androidportfolio.R
import com.example.androidportfolio.base.BaseActivity
import com.example.androidportfolio.databinding.ActivityViewPagerBinding
import com.example.androidportfolio.util.viewBinding

class MyCareersActivity : BaseActivity(R.layout.activity_view_pager) {

    private val binding by viewBinding(ActivityViewPagerBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pagerAdapter = MyCareersViewPagerAdapter(this)
        binding.viewPager.adapter = pagerAdapter
    }
}
