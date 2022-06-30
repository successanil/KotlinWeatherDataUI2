package com.relsellglobal.interfacesgateway.network

import com.relsellglobal.modelslib.CityContentDetailNetwork
import com.relsellglobal.modelslib.CityContentNetwork

interface IGApiService {
    suspend fun getWeatherDataCityList() : List<CityContentNetwork>

    suspend fun getWeatherDataCityListForWorkManager() : List<CityContentNetwork>

    suspend fun fetchTempretureForCity(cityName:String) : CityContentDetailNetwork
}