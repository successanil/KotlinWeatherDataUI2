package com.relsellglobal.firebasedatabasedemo.di


import com.relsellglobal.firebasedatabasedemo.MainActivityForWeatherData
import com.relsellglobal.firebasedatabasedemo.MyApplication
import com.relsellglobal.firebasedatabasedemo.ui.home.HomeActivity
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules=[
    AndroidInjectionModule::class,
    ActivitiesContributerModule::class,
    NetworkModule::class,
    LocalDBMod::class,
    FragmentContributerModule::class])
interface AppComponent {
    fun inject(app: MyApplication)
}