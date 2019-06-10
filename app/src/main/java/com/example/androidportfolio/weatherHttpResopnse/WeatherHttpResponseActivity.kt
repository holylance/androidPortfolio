package com.example.androidportfolio.weatherHttpResopnse

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.androidportfolio.R
import com.example.androidportfolio.base.BaseActivity
import com.example.androidportfolio.network.RetrofitServiceGenerator
import com.example.androidportfolio.network.WeatherData
import com.example.androidportfolio.network.WeatherService
import kotlinx.android.synthetic.main.activity_weather_http_response.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherHttpResponseActivity : BaseActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_weather_http_response)

    setUp()

    setRetrofitService(weatherDetail)
  }

  private fun setRetrofitService(v: TextView) {
    val service = RetrofitServiceGenerator.createService(WeatherService::class.java)
    val request = service.getCurrentWeather(RetrofitServiceGenerator.strKey, "Berlin,de")
    request.enqueue(object : Callback<WeatherData> {
      override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {
        v.text = response.body().toString()
      }

      override fun onFailure(call: Call<WeatherData>, t: Throwable) {
        Log.d("ERROR", t.toString())
      }
    })
  }
}
