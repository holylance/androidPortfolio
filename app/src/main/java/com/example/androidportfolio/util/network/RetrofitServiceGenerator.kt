package com.example.androidportfolio.util.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory

class RetrofitServiceGenerator {
    companion object {
        private const val strURL = "https://api.openweathermap.org/data/2.5/"
        const val strKey = "dfd960e130cbd5205800c50c8530d5dc"
        private val httpClient = OkHttpClient.Builder()
        private val builder = Retrofit.Builder()
            .baseUrl(strURL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())

        private val retrofit = builder.build()
        fun <S> createService(serviceClass: Class<S>): S {
            return retrofit.create(serviceClass)
        }
    }
}
