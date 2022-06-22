package com.relsellglobal.firebasedatabasedemo.di

import com.relsellglobal.firebasedatabasedemo.utils.AppConstants
import com.relsellglobal.networklib.apiservice.WeatherHerokuApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl(AppConstants.Http.baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun providesWeatherApiService(retrofit: Retrofit) : WeatherHerokuApiService {
        return retrofit.create(WeatherHerokuApiService::class.java)
    }

}