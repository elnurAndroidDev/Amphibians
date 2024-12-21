package com.isayevapps.amphibians

import android.app.Application
import com.isayevapps.amphibians.data.AppContainer
import com.isayevapps.amphibians.data.DefaultAppContainer

class AmphibiansApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}