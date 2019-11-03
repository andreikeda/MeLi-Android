package com.example.meli

import android.app.Application
import com.example.meli.core.networkModule
import org.koin.android.ext.android.startKoin

class MeLiApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, arrayListOf(networkModule))
    }
}
