package com.example.cryptoapp.view.fragment

import com.example.cryptoapp.databinding.CryptoFragmentBinding
import com.nhaarman.mockitokotlin2.mock
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

@RunWith(JUnit4::class)
class CryptoFragmentTest : KoinTest {

    private val viewModel by inject<CryptoViewModel>()
    private lateinit var dataBinding: CryptoFragmentBinding

    @Before
    public fun setup(){
//        withTestAppli
    }

    @Test
    fun testViewModelEquals() {
        dataBinding = mock()
        assertEquals(viewModel, dataBinding.viewModel)
    }

    @After
    fun tearDown(){
        stopKoin()
    }
}