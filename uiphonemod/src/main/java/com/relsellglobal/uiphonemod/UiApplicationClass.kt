package com.relsellglobal.uiphonemod

import android.app.Application
import com.relsellglobal.uiphonemod.di.AppComponent
import com.relsellglobal.uiphonemod.di.DaggerAppComponent
import com.relsellglobal.uiphonemod.di.LocalDBMod
//import com.relsellglobal.uiphonemod.di.DaggerAppComponent
import com.relsellglobal.uiphonemod.di.MultiMods
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class UiApplicationClass : Application(), HasAndroidInjector {

    lateinit var applicationComponent: AppComponent

    @Inject
    lateinit var mInjecter: DispatchingAndroidInjector<Any>


    override fun onCreate() {
        super.onCreate()


        //applicationComponent = DaggerAppComponent.create()
        applicationComponent = DaggerAppComponent
            .builder()
            .localDBMod(LocalDBMod(this))
            .build()
        applicationComponent.inject2(this)



    }

    override fun androidInjector(): AndroidInjector<Any> {
        return mInjecter
    }


}