package com.relsellglobal.uiphonemod.di

import com.relsellglobal.progressbarlib.ChildFragment
import com.relsellglobal.uiphonemod.PhoneModFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentContributerModule {

    @ContributesAndroidInjector
    abstract fun contributesChildFragment() : ChildFragment

    @ContributesAndroidInjector
    abstract fun contributesPhoneFragment() : PhoneModFragment
}