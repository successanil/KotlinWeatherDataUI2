package com.relsellglobal.uiphonemod

import android.app.Application
import com.relsellglobal.uiphonemod.di.AppComponent
import com.relsellglobal.uiphonemod.di.DaggerAppComponent
import com.relsellglobal.uiphonemod.di.MultiMods

class UiApplicationClass : Application () {

    lateinit var applicationComponent : AppComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerAppComponent.create()

    }
}