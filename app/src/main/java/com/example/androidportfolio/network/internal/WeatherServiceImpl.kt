package com.example.androidportfolio.network.internal

import com.example.androidportfolio.network.WeatherService
import com.example.androidportfolio.network.model.WeatherData
import io.reactivex.rxjava3.core.Single

internal class WeatherServiceImpl(private val weatherApiService: WeatherApiService) : WeatherService {

    override fun getCurrentWeather(): Single<WeatherData> {
        return weatherApiService.getCurrentWeather(KEY, QUERY)
            .map { it.toWeatherData() }
    }

    companion object {
        private const val KEY = "dfd960e130cbd5205800c50c8530d5dc"
        private const val QUERY = "Berlin,de"
    }
}
