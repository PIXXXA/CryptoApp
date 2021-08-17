package com.example.cryptoapp.module

import com.example.cryptoapp.BuildConfig.SERVER_URL
import com.example.cryptoapp.rest.IServiceApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createRetrofit(): List<Module> {

    val module = module {
        single {
            okHttp()
            initRetrofit()
            get<Retrofit>().create(IServiceApi::class.java)
        }
    }
    return listOf(module)
}

private fun okHttp(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder().addInterceptor(interceptor).build()
}

private fun initRetrofit() = Retrofit.Builder()
    .baseUrl(SERVER_URL)
    .client(okHttp())
    .callFactory(okHttp())
    .addConverterFactory(GsonConverterFactory.create()).build()