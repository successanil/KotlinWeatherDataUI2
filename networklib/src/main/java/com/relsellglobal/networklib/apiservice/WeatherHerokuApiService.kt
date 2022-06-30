package com.relsellglobal.networklib.apiservice

import com.relsellglobal.interfacesgateway.network.IGApiService
import com.relsellglobal.modelslib.CityContentDetailNetwork
import com.relsellglobal.modelslib.CityContentNetwork
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherHerokuApiService : IGApiService {
    @GET("getWeatherDataList")
    override suspend fun getWeatherDataCityList() : List<CityContentNetwork>

    @GET("getWeatherDataList")
    override suspend fun getWeatherDataCityListForWorkManager() : List<CityContentNetwork>

    @GET("fetchTempretureForCity")
    override suspend fun fetchTempretureForCity(@Query("cityName")  cityName:String) : CityContentDetailNetwork
}