package com.example.cryptoapp.model

import com.google.gson.annotations.SerializedName

data class CryptoListResponse(

    @SerializedName("data")
    val data: List<CryptoDetailsResponse>
)