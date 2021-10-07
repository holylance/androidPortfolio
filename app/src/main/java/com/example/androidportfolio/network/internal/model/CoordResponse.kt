package com.example.androidportfolio.network.internal.model

import com.example.androidportfolio.network.model.Coord

internal data class CoordResponse(
    val lon: Double,
    val lat: Double
) {
    internal fun toCoord() =
        Coord(
           lon = lon,
           lat = lat
        )
}
