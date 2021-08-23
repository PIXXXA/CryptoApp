package com.example.cryptoapp.model

import com.google.gson.annotations.SerializedName

data class CryptoDetailsModel(

    @SerializedName("data")
    val data: List<CryptoDataListModel>
)