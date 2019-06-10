package com.example.androidportfolio.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherData (
  @SerializedName("coord")
  @Expose
  val coord: Coord,
  @SerializedName("weather")
  @Expose
  val weather: List<Weather>? = null,
  @SerializedName("base")
  @Expose
  val base: String,
  @SerializedName("main")
  @Expose
  val main: Main,
  @SerializedName("visibility")
  @Expose
  val visibility: Int,
  @SerializedName("wind")
  @Expose
  val wind: Wind,
  @SerializedName("clouds")
  @Expose
  val clouds: Clouds,
  @SerializedName("dt")
  @Expose
  val dt: Int,
  @SerializedName("sys")
  @Expose
  val sys: Sys,
  @SerializedName("timezone")
  @Expose
  val timezone: Int,
  @SerializedName("id")
  @Expose
  val id: Int,
  @SerializedName("name")
  @Expose
  val name: String,
  @SerializedName("cod")
  @Expose
  val cod: String
)

data class Clouds (
  @SerializedName("all")
  @Expose
  val all: Int
)

data class Coord (
  @SerializedName("lon")
  @Expose
  val lon: Double,
  @SerializedName("lat")
  @Expose
  val lat: Double
)

data class Main (
  @SerializedName("temp")
  @Expose
  val temp: Double,
  @SerializedName("pressure")
  @Expose
  val pressure: Int,
  @SerializedName("humidity")
  @Expose
  val humidity: Int,
  @SerializedName("temp_min")
  @Expose
  val tempMin: Double,
  @SerializedName("temp_max")
  @Expose
  val tempMax: Double
)

data class Sys(
  @SerializedName("type")
  @Expose
  val type: Int,
  @SerializedName("id")
  @Expose
  val id: Int,
  @SerializedName("message")
  @Expose
  val message: Double,
  @SerializedName("country")
  @Expose
  val country: String,
  @SerializedName("sunrise")
  @Expose
  val sunrise: Int,
  @SerializedName("sunset")
  @Expose
  val sunset: Int
)

data class Weather(
  @SerializedName("id")
  @Expose
  val id: Int,
  @SerializedName("main")
  @Expose
  val main: String,
  @SerializedName("description")
  @Expose
  val description: String,
  @SerializedName("icon")
  @Expose
  val icon: String
)

data class Wind(
  @SerializedName("speed")
  @Expose
  val speed: Double,
  @SerializedName("deg")
  @Expose
  val deg: Int
)
