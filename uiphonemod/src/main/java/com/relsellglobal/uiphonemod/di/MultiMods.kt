package com.relsellglobal.uiphonemod.di

import com.relsellglobal.progressbarlib.ChildDepedency
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class MultiMods {
    var childDepedency : ChildDepedency ?= null

    @Singleton
    @Provides
    fun provideProgressLibChildDependency() : ChildDepedency {
        if(childDepedency == null) {
            childDepedency = ChildDepedency()
        }
        return childDepedency!!
    }
}