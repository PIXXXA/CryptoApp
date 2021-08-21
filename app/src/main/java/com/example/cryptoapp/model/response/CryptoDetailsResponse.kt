package com.example.cryptoapp.model.response

import com.google.gson.annotations.SerializedName

data class CryptoDetailsResponse(

    @SerializedName("csupply")
    val csupply: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("market_cap_usd")
    val market_cap_usd: String,

    @SerializedName("msupply")
    val msupply: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("nameid")
    val nameid: String,

    @SerializedName("percent_change_1h")
    val percent_change_1h: String,

    @SerializedName("percent_change_24h")
    val percent_change_24h: String,

    @SerializedName("percent_change_7d")
    val percent_change_7d: String,

    @SerializedName("price_btc")
    val price_btc: String,

    @SerializedName("price_usd")
    val price_usd: String,

    @SerializedName("rank")
    val rank: Int,

    @SerializedName("symbol")
    val symbol: String,

    @SerializedName("tsupply")
    val tsupply: String,

    @SerializedName("volume24")
    val volume24: Double,

    @SerializedName("volume24a")
    val volume24a: Double
)