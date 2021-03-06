package com.example.cryptoapp

import android.app.Application
import com.example.cryptoapp.rest.IServiceApi
import com.example.cryptoapp.view.fragment.CryptoViewModel
import com.nhaarman.mockitokotlin2.mock
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.test.KoinTest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(JUnit4::class)
class BaseApplicationTest : KoinTest {

    private lateinit var application: BaseApplication

    @Test
    fun testInitializedKoinModules() {
        application = mock()
        val testInitKoin = insertKoin(application, initModules())
        val initKoin = application.insertKoin(application, application.initModules())
        assertEquals(testInitKoin, initKoin)
    }

    private fun initModules(): List<Module> {
        val moduleList = arrayListOf<Module>()
        moduleList.addAll(createTestModules())
        return moduleList
    }

    private fun insertKoin(application: Application, moduleList: List<Module>) {
        startKoin {
            androidLogger()
            androidContext(application)
            modules(moduleList)
        }
    }
}

private fun createTestModules(): List<Module> {

    val viewModel = module {
        viewModel { CryptoViewModel(get()) }
    }

    val module = module {
        single {
            okHttp()
        }
        single {
            get<Retrofit>().create(IServiceApi::class.java)
        }
        single {
            initRetrofit()
        }
    }
    return arrayListOf(module, viewModel)
}

private fun okHttp(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder().addInterceptor(interceptor).build()
}

private fun initRetrofit() = Retrofit.Builder()
    .baseUrl(BuildConfig.SERVER_URL)
    .client(okHttp())
    .callFactory(okHttp())
    .addConverterFactory(GsonConverterFactory.create()).build()