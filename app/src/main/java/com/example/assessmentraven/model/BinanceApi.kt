package com.example.assessmentraven.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface BinanceApi {

    @GET("api/v3/klines?symbol=BTCUSDT&interval=1d")
    suspend fun getChartData(): List<List<Any>>


    @GET("api/v3/klines")
    suspend fun getBLines(
        @Query("symbol") symbol: String,
        @Query("interval") interval: String
    ): List<List<Any>>
}



object ApiClient {
    private const val BASE_URL = "https://api.binance.com/"
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

