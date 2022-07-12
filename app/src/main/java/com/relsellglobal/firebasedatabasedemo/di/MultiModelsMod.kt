package com.relsellglobal.firebasedatabasedemo.di

import com.relsellglobal.modelslib.CityContent
import com.relsellglobal.modelslib.CityContentDetailNetwork
import com.relsellglobal.modelslib.CityContentNetwork
import dagger.Module
import dagger.Provides

@Module
class MultiModelsMod {

    @Provides
    fun providesCityContent() : CityContent {
        return CityContent()
    }

    @Provides
    fun providesCityContentDetailNetwork() : CityContentDetailNetwork {
        return CityContentDetailNetwork()
    }

    @Provides
    fun providesCityContentNetwork() : CityContentNetwork {
        return CityContentNetwork()
    }

}