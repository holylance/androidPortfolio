package com.example.androidportfolio.weatherapi

import android.os.Bundle
import android.view.View
import com.example.androidportfolio.R
import com.example.androidportfolio.base.BaseFragment
import com.example.androidportfolio.databinding.WeatherApiFragmentBinding
import com.example.androidportfolio.util.viewBinding

class WeatherApiFragment : BaseFragment(R.layout.weather_api_fragment) {

    private val binding by viewBinding(WeatherApiFragmentBinding::bind)
    private val viewModel = WeatherApiViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setRetrofitService(binding.weatherDetail)
    }
}
