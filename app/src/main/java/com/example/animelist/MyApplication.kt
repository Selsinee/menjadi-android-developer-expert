package com.example.animelist

import android.app.Application
import com.example.animelist.core.di.databaseModule
import com.example.animelist.core.di.networkModule
import com.example.animelist.core.di.repositoryModule
import com.example.animelist.di.useCaseModule
import com.example.animelist.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

/**
 * Created by Seline on 02/03/2022 17:32
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}