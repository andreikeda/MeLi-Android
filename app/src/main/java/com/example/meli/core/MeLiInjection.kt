package com.example.meli.core

import com.example.meli.core.repository.MeLiServiceAPI
import org.koin.dsl.module.module

var networkModule = module {
    single { MeLiServiceAPI() }
}
