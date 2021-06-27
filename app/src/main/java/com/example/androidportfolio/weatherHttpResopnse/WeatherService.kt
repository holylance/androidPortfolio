package com.example.androidportfolio.weatherHttpResopnse

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("weather")
    fun getCurrentWeather(
        @Query("appid")
        apiKey: String,
        @Query("q")
        query: String
    ): Single<WeatherData>
}
