package com.example.cryptoapp.model

import com.google.gson.annotations.SerializedName

data class CryptoListModel(

    @SerializedName("data")
    val data: List<CryptoDetailsModel>
)