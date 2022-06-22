package com.relsellglobal.firebasedatabasedemo.repository.network

import com.relsellglobal.firebasedatabasedemo.models.CityContentDetailNetwork
import com.relsellglobal.firebasedatabasedemo.models.CityContentNetwork
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherHerokuApiService {
    @GET("getWeatherDataList")
    suspend fun getWeatherDataCityList() : List<CityContentNetwork>

    @GET("fetchTempretureForCity")
    suspend fun fetchTempretureForCity(@Query("cityName")  cityName:String) : CityContentDetailNetwork
}