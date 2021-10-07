package com.example.androidportfolio.network.model

import java.io.Serializable

data class Main (
    val temp: Double,
    val pressure: Int,
    val humidity: Int,
    val tempMin: Double,
    val tempMax: Double
) : Serializable
