package com.example.androidportfolio.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
  @GET("weather")
  fun getCurrentWeather(
    @Query("appid")
    apiKey: String,
    @Query("q")
    query: String
  ): Observable<WeatherData>
}
