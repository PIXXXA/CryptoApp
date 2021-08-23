package com.example.cryptoapp.view.fragment

import com.example.cryptoapp.model.CryptoDetailsModel
import com.example.cryptoapp.rest.IServiceApi
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertNotEquals

@RunWith(JUnit4::class)
@ExperimentalCoroutinesApi
class CryptoViewModelTest {

    lateinit var serviceApi: IServiceApi
    private val viewModel: CryptoViewModel = mock()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @ObsoleteCoroutinesApi
    @Test
    fun testServiceRequest() = mainCoroutineRule.runBlockingTest {
        serviceApi = mock()
        whenever(serviceApi.getCryptoData(INVALID_LIMIT).isSuccessful.not())
        whenever(serviceApi.getCryptoData(VALID_LIMIT).isSuccessful)
    }

    @Test
    fun testIsLoadingVariable() {
        val isLoadingTest = viewModel.isLoading
        Assert.assertNotEquals(false, isLoadingTest)
    }

    @Test
    fun testLiveDataSortMethod() {
        val list = listOf<CryptoDetailsModel>()
        assertNotEquals(list, viewModel.cryptoList.value)
    }

    companion object {
        const val INVALID_LIMIT = -20
        const val VALID_LIMIT = 20
    }
}