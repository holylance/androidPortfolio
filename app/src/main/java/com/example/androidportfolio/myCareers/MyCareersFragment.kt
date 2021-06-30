package com.example.androidportfolio.myCareers

import android.os.Bundle
import android.view.View
import com.example.androidportfolio.R
import com.example.androidportfolio.base.BaseFragment
import com.example.androidportfolio.databinding.MyCareersFragmentBinding
import com.example.androidportfolio.util.viewBinding

class MyCareersFragment : BaseFragment(R.layout.my_careers_fragment) {
    private val binding by viewBinding(MyCareersFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pagerAdapter = MyCareersViewPagerAdapter(requireContext())
        binding.viewPager.adapter = pagerAdapter
    }

    override fun onDestroyView() {
        binding.viewPager.adapter = null
        super.onDestroyView()
    }
}
