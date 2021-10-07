package com.example.androidportfolio.network

import com.example.androidportfolio.network.model.WeatherData
import io.reactivex.rxjava3.core.Single

/**
 * [WeatherService] to call weather endpoints.
 */
interface WeatherService {

    /**
     * Returns the current weather data.
     *
     * @return WeatherData data class
     */
    fun getCurrentWeather(): Single<WeatherData>
}
