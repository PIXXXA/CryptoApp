package com.example.cryptoapp

import android.app.Application
import com.example.cryptoapp.module.createCryptoModule
import com.example.cryptoapp.module.createRetrofit
import com.example.cryptoapp.view.fragment.CryptoFragment
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class BaseApplication : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        insertKoin(this, initModules())
    }

    private fun initModules(): List<Module> {
        val moduleList = arrayListOf<Module>()
        moduleList.addAll(createRetrofit())
        moduleList.addAll(createCryptoModule())
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