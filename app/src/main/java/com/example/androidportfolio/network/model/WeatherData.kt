package com.example.androidportfolio.network.model

import java.io.Serializable

data class WeatherData (
  val coord: Coord,
  val weather: List<Weather>? = null,
  val base: String,
  val main: Main,
  val visibility: Int,
  val wind: Wind,
  val clouds: Clouds,
  val dt: Int,
  val sys: Sys,
  val timezone: Int,
  val id: Int,
  val name: String,
  val cod: String
) : Serializable
