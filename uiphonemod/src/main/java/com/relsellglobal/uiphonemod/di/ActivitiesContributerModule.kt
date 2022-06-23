package com.relsellglobal.uiphonemod.di

import com.relsellglobal.uiphonemod.UiPhoneActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesContributerModule {

    @ContributesAndroidInjector
    abstract fun contributeUiPhoneActivity() : UiPhoneActivity
}