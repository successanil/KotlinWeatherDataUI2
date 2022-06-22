package com.relsellglobal.firebasedatabasedemo.di

import com.relsellglobal.firebasedatabasedemo.FrontListFragment
import com.relsellglobal.firebasedatabasedemo.ui.home.HomeFragment
import com.relsellglobal.progressbarlib.ChildFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentContributerModule {
    @ContributesAndroidInjector
    abstract fun contributesHomeFragment() : HomeFragment

    @ContributesAndroidInjector
    abstract fun contributesFrontListFragment() : FrontListFragment
}