package com.example.androidportfolio.weatherapi

import android.widget.TextView
import com.example.androidportfolio.base.BaseViewModel
import com.example.androidportfolio.network.RetrofitServiceGenerator
import com.example.androidportfolio.network.internal.WeatherApiService
import com.example.androidportfolio.network.internal.WeatherServiceImpl
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class WeatherApiViewModel : BaseViewModel() {

    fun setRetrofitService(v: TextView) {
        val apiService = RetrofitServiceGenerator.createService(WeatherApiService::class.java)
        val service = WeatherServiceImpl(apiService)
        service.getCurrentWeather()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { v.text = it.toString() },
                { v.text = it.printStackTrace().toString() }
            )
    }
}
