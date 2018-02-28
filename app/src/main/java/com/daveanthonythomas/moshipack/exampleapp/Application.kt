package com.daveanthonythomas.moshipack.exampleapp

import android.app.Application
import org.koin.android.ext.android.startKoin

/**
 * Created by dave on 2018-02-25.
 */
class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(AppModule.module))
    }
}

