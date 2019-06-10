package com.example.androidportfolio.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
  @GET("weather")
  fun getCurrentWeather(
    @Query("appid")
    apiKey: String,
    @Query("q")
    query: String
  ): Call<WeatherData>
}
