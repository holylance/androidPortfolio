package com.example.androidportfolio.network.internal

import com.example.androidportfolio.network.internal.model.WeatherDataResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

internal interface WeatherApiService {

    @GET("weather")
    fun getCurrentWeather(
        @Query("appid")
        apiKey: String,
        @Query("q")
        query: String
    ): Single<WeatherDataResponse>
}
