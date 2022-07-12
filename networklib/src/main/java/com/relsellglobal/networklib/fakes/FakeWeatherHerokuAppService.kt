package com.relsellglobal.networklib.fakes

import com.relsellglobal.interfacesgateway.appinterfaces.network.IGApiService
import com.relsellglobal.modelslib.CityContentDetailNetwork
import com.relsellglobal.modelslib.CityContentNetwork
import com.relsellglobal.modelslib.MainData
import com.relsellglobal.modelslib.Weather

object FakeWeatherHerokuAppService : IGApiService {

    override suspend fun getWeatherDataCityList(): List<CityContentNetwork> {
        var mutableList = mutableListOf<CityContentNetwork>()
        var cityContentNetwork = CityContentNetwork("Fake Delhi")
        mutableList.add(cityContentNetwork)
        return mutableList
    }

    override suspend fun getWeatherDataCityListForWorkManager(): List<CityContentNetwork> {
        var mutableList = mutableListOf<CityContentNetwork>()
        var cityContentNetwork = CityContentNetwork("Fake Delhi")
        mutableList.add(cityContentNetwork)
        return mutableList
    }

    override suspend fun fetchTempretureForCity(cityName: String): CityContentDetailNetwork {
        var mainData = MainData()
        var weather = Weather()

        var weatherList = ArrayList<Weather>()
        weatherList.add(weather)

        return CityContentDetailNetwork("Fake temp",weatherList,mainData)
    }

}