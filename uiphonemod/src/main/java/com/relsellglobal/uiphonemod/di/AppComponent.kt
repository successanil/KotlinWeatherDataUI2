package com.relsellglobal.uiphonemod.di

import com.relsellglobal.uiphonemod.UiApplicationClass
import com.relsellglobal.uiphonemod.UiPhoneActivity
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules=[
    AndroidInjectionModule::class,
    ActivitiesContributerModule::class,
    MultiMods::class,
    LocalDBMod::class,
    FragmentContributerModule::class])
interface AppComponent {
    fun inject2(applicationClass: UiApplicationClass)
}