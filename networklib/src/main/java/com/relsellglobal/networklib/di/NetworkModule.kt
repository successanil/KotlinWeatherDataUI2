package com.relsellglobal.networklib.di


import com.relsellglobal.interfacesgateway.appinterfaces.network.IGApiService
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
    fun providesBaseUrl () : String {
        return "https://arcane-wildwood-52412.herokuapp.com/"
    }


    @Singleton
    @Provides
    fun providesRetrofit(baseUrl:String) : Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun providesWeatherApiService(retrofit: Retrofit) : WeatherHerokuApiService {
        return retrofit.create(WeatherHerokuApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesIGApiServiceForWeatherService(weatherHerokuApiService: WeatherHerokuApiService) : IGApiService {
        return weatherHerokuApiService
    }

}