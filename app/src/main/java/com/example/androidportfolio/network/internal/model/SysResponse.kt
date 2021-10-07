package com.example.androidportfolio.network.internal.model

import com.example.androidportfolio.network.model.Sys

internal data class SysResponse(
    val type: Int,
    val id: Int,
    val message: Double,
    val country: String,
    val sunrise: Int,
    val sunset: Int
) {
    internal fun toSys() =
        Sys(
            type = type,
            id = id,
            message = message,
            sunrise = sunrise,
            sunset = sunset
        )
}
