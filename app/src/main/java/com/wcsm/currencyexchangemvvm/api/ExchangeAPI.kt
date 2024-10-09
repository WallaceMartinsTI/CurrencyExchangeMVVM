package com.wcsm.currencyexchangemvvm.api

import android.util.Log

class ExchangeAPI {
    private val TAG = "#-# ExchangeAPI #-#"

    suspend fun getConvertedValue(baseCode: String, targetCode: String, value: Double) : Double {
        val exchangeRateAPI = RetrofitService.getExchangeRateAPI()

        try {
            val response = exchangeRateAPI.getConvertedValue(baseCode, targetCode, value)
            if(response.isSuccessful) {
                Log.i(TAG, "Response successfully!")
                val result = response.body()?.conversion_result
                if(result != null) {
                    return result
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e(TAG, "Response with error", e)
        }

        return 0.0
    }
}