package com.wcsm.currencyexchangemvvm.api

import com.wcsm.currencyexchangemvvm.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    const val EXCHANGE_RATE_API_KEY = BuildConfig.EXCHANGE_RATE_API_KEY
    const val BASE_URL = "https://v6.exchangerate-api.com/v6/${EXCHANGE_RATE_API_KEY}/"

    fun getExchangeRateAPI() : ExchangeRateAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ExchangeRateAPI::class.java)
    }
}