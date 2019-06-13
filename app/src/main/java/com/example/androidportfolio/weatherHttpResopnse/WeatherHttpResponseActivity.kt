package com.example.androidportfolio.weatherHttpResopnse

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.androidportfolio.R
import com.example.androidportfolio.base.BaseActivity
import com.example.androidportfolio.network.RetrofitServiceGenerator
import com.example.androidportfolio.network.WeatherService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.activity_weather_http_response.*

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
    val result = request.subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribeBy (
        onNext = { v.text = it.toString() },
        onError = { Log.d("ERROR", it.printStackTrace().toString()) },
        onComplete = { Log.d("COMPLETE", "Done") }
      )
  }
}
