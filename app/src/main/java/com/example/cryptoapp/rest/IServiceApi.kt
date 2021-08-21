package com.example.cryptoapp.rest

import com.example.cryptoapp.model.response.CryptoListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IServiceApi {

    @GET("tickers")
    suspend fun getCryptoData(@Query(value = "limit") limit: Int) : Response<CryptoListResponse>
}