package com.example.cryptoapp.view.fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.model.CryptoDetailsModel
import com.example.cryptoapp.rest.IServiceApi
import kotlinx.coroutines.*
import org.koin.core.component.KoinComponent
import retrofit2.HttpException
import java.io.IOException

class CryptoViewModel(private val serviceApi: IServiceApi) : ViewModel(), KoinComponent {

    private val _cryptoList = MutableLiveData<List<CryptoDetailsModel>>()
    var cryptoList: LiveData<List<CryptoDetailsModel>> = _cryptoList

    var isLoading = MutableLiveData<Boolean>()

    init {
        startUpdateCryptoData()
    }

    private fun startUpdateCryptoData() {
        viewModelScope.launch {
            while (isActive) {
                getCryptoData(LIMIT_VALUE)
                delay(DELAY)
            }
        }
    }

    private suspend fun getCryptoData(listLimit: Int) {
        try {
            viewModelScope.launch {
                withContext(Dispatchers.IO) {
                    val result = serviceApi.getCryptoData(listLimit)
                    _cryptoList.postValue(result.body()?.data?.sortedBy { it.name })
                }
            }
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> {
                    Log.d(IO_EXCEPTION_TAG, null, throwable)
                }
                is HttpException -> {
                    Log.d(HTTP_EXCEPTION_TAG, null, throwable)
                }
                else -> {
                    Log.d(OTHER_EXCEPTION_TAG, null, throwable)
                }
            }
        }
    }

    companion object {

        const val IO_EXCEPTION_TAG = "IOException"
        const val HTTP_EXCEPTION_TAG = "HttpException"
        const val OTHER_EXCEPTION_TAG = "HttpException"

        const val DELAY = 30000L
        const val LIMIT_VALUE = 20
    }
}