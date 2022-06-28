package com.relsellglobal.firebasedatabasedemo

import android.app.Application
import android.content.SharedPreferences
import com.relsellglobal.firebasedatabasedemo.di.AppComponent
import com.relsellglobal.firebasedatabasedemo.di.DaggerAppComponent
import com.relsellglobal.firebasedatabasedemo.di.LocalDBMod
import com.relsellglobal.firebasedatabasedemo.repository.WeatherDataRepository
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApplication : Application(), HasAndroidInjector {
    @Inject
    lateinit var mInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var weatherDataRepository: WeatherDataRepository

    lateinit var appComponent: AppComponent

    var sp : SharedPreferences ?= null

    override fun androidInjector(): AndroidInjector<Any> {
        return mInjector
    }


    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .localDBMod(LocalDBMod(this))
            .build()

        appComponent.inject(this)

        myApplication = this

    }

    fun getSharePref() : SharedPreferences {
        if(sp == null) {
            initializeSp()
        }
        return sp!!
    }

    fun initializeSp()  {
        sp = myApplication?.getSharedPreferences("MySharedPref", MODE_APPEND)
    }

    companion object {
        var myApplication : MyApplication ?= null


        fun getMyApplicationObj () : MyApplication {
            return myApplication!!
        }


    }

}