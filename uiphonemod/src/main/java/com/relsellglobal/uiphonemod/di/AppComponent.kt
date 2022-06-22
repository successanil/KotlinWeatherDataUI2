package com.relsellglobal.uiphonemod.di

import com.relsellglobal.uiphonemod.UiApplicationClass
import com.relsellglobal.uiphonemod.UiPhoneActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules=[MultiMods::class])
interface AppComponent {
    fun inject(app:UiPhoneActivity)

}