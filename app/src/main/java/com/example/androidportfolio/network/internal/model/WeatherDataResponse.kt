package com.example.androidportfolio.network.internal.model

import com.example.androidportfolio.network.model.WeatherData

internal data class WeatherDataResponse(
    val coord: CoordResponse,
    val weather: List<WeatherResponse>? = null,
    val base: String,
    val main: MainResponse,
    val visibility: Int,
    val wind: WindResponse,
    val clouds: CloudsResponse,
    val dt: Int,
    val sys: SysResponse,
    val timezone: Int,
    val id: Int,
    val name: String,
    val cod: String
) {
    internal fun toWeatherData() =
        WeatherData(
            coord = coord.toCoord(),
            weather = weather?.map { it.toWeather() },
            base = base,
            main = main.toMain(),
            visibility = visibility,
            wind = wind.toWind(),
            clouds = clouds.toClouds(),
            dt = dt,
            sys = sys.toSys(),
            timezone = timezone,
            id = id,
            name = name,
            cod = cod
        )
}
