package com.relsellglobal.networklib.apiservice

import com.relsellglobal.modelslib.CityContentDetailNetwork
import com.relsellglobal.modelslib.CityContentNetwork
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherHerokuApiService {
    @GET("getWeatherDataList")
    suspend fun getWeatherDataCityList() : List<CityContentNetwork>

    @GET("getWeatherDataList")
    suspend fun getWeatherDataCityListForWorkManager() : Response<List<CityContentNetwork>>

    @GET("fetchTempretureForCity")
    suspend fun fetchTempretureForCity(@Query("cityName")  cityName:String) : CityContentDetailNetwork
}