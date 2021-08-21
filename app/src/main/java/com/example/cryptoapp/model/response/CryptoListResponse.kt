package com.example.cryptoapp.model.response

import com.example.cryptoapp.model.response.CryptoDetailsResponse
import com.google.gson.annotations.SerializedName

data class CryptoListResponse(

    @SerializedName("data")
    val data: List<CryptoDetailsResponse>
)