package com.relsellglobal.uiphonemod.di

import com.relsellglobal.uiphonemod.UiApplicationClass
import com.relsellglobal.uiphonemod.UiPhoneActivity
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules=[
    AndroidInjectionModule::class,
    MultiMods::class,
    FragmentContributerModule::class])
interface AppComponent {
    fun inject(app:UiPhoneActivity)

}