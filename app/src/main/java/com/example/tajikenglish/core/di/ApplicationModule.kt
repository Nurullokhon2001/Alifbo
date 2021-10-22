package com.example.tajikenglish.core.di

import com.example.tajikenglish.repository.MainRepository
import com.example.tajikenglish.repository.MainRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

object ApplicationModule {
    val applicationModule: Module = module {
        factory<MainRepository> { MainRepositoryImpl(androidContext()) }
    }
}
