package com.example.cryptoapp.module

import com.example.cryptoapp.view.fragment.CryptoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun createCryptoModule(): List<Module> {

    val viewModel = module {
        viewModel { CryptoViewModel() }
    }

    return listOf(viewModel)
}