package com.wcsm.currencyexchangemvvm.api

import com.wcsm.currencyexchangemvvm.model.ExchangeRateResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ExchangeRateAPI {

    //GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP
    @GET("pair/{base}/{target}/{value}")
    suspend fun getConvertedValue(
        @Path("base") base: String,
        @Path("target") target: String,
        @Path("value") value: Double
    ) : Response<ExchangeRateResponse>

}