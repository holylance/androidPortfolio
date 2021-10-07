package com.example.androidportfolio.network.internal.model

import com.example.androidportfolio.network.model.Wind

internal class WindResponse(
    val speed: Double,
    val deg: Int
) {
    internal fun toWind() =
        Wind(
            speed = speed,
            deg = deg
        )
}
