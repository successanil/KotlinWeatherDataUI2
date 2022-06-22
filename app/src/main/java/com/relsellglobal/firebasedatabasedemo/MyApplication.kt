package com.relsellglobal.firebasedatabasedemo

import android.app.Application
import com.relsellglobal.firebasedatabasedemo.di.AppComponent
import com.relsellglobal.firebasedatabasedemo.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApplication : Application(), HasAndroidInjector {
    @Inject
    lateinit var mInjector: DispatchingAndroidInjector<Any>

    lateinit var appComponent: AppComponent

    override fun androidInjector(): AndroidInjector<Any> {
        return mInjector
    }


    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()

    }

}