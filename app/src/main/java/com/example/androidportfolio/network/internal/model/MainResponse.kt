package com.example.androidportfolio.network.internal.model

import com.example.androidportfolio.network.model.Main

internal data class MainResponse(
    val temp: Double,
    val pressure: Int,
    val humidity: Int,
    val tempMin: Double,
    val tempMax: Double
) {
    internal fun toMain() =
        Main(
            temp = temp,
            pressure = pressure,
            humidity = humidity,
            tempMin = tempMin,
            tempMax = tempMax
        )
}
