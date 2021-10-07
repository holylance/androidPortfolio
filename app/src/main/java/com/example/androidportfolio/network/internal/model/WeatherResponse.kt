package com.example.androidportfolio.network.internal.model

import com.example.androidportfolio.network.model.Weather

internal data class WeatherResponse(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
) {
    fun toWeather() =
        Weather(
            id = id,
            main = main,
            description = description,
            icon = icon
        )
}
