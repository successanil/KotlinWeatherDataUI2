package com.relsellglobal.repositorymodule.di

import com.relsellglobal.localdblib.database.CityDatabase
import com.relsellglobal.networklib.apiservice.WeatherHerokuApiService
import com.relsellglobal.repositorymodule.WeatherDataRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryMod {
    @Provides
    @Singleton
    fun providesWeatherDataRepository(igWeatherHerokuApiService: WeatherHerokuApiService,cityDatabase: CityDatabase) : WeatherDataRepository{
        return WeatherDataRepository(igWeatherHerokuApiService,cityDatabase)
    }
}