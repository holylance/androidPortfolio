package com.example.androidportfolio.weatherHttpResopnse

import android.os.Bundle
import android.widget.TextView
import com.example.androidportfolio.R
import com.example.androidportfolio.base.BaseActivity
import com.example.androidportfolio.databinding.ActivityWeatherHttpResponseBinding
import com.example.androidportfolio.network.RetrofitServiceGenerator
import com.example.androidportfolio.network.WeatherService
import com.example.androidportfolio.util.viewBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class WeatherHttpResponseActivity : BaseActivity(R.layout.activity_weather_http_response) {

    private val binding by viewBinding(ActivityWeatherHttpResponseBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setRetrofitService(binding.weatherDetail)
    }

    private fun setRetrofitService(v: TextView) {
        val service = RetrofitServiceGenerator.createService(WeatherService::class.java)
        val request = service.getCurrentWeather(RetrofitServiceGenerator.strKey, "Berlin,de")
        val result = request.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            //.subscribe(
            //    { v.text = it.toString() },
            //    { Log.d("ERROR", it.printStackTrace().toString()) }
            //)
            // TODO: Make ViewModel first.
    }
}
