package com.example.cryptoapp.view.fragment

import com.example.cryptoapp.model.CryptoDataListModel
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
import retrofit2.Response
import kotlin.test.assertTrue

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
        whenever(serviceApi.getCryptoData(VALID_LIMIT)).thenReturn(
            Response.success(
                CryptoDetailsModel(
                    listOf()
                )
            )
        )
        assertTrue(serviceApi.getCryptoData(VALID_LIMIT).isSuccessful)
    }

    @Test
    fun testIsLoadingVariable() {
        val isLoadingTest = viewModel.isLoading
        Assert.assertNotEquals(false, isLoadingTest)
    }

    companion object {
        const val VALID_LIMIT = 20
    }
}