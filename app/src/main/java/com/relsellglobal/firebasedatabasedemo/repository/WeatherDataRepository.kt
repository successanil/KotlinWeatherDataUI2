package com.relsellglobal.firebasedatabasedemo.repository

import com.relsellglobal.firebasedatabasedemo.models.CityContentDetailNetwork
import com.relsellglobal.firebasedatabasedemo.models.CityContentNetwork
import com.relsellglobal.firebasedatabasedemo.repository.network.WeatherHerokuApiService
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class WeatherDataRepository @Inject constructor(private val weatherHerokuApiService: WeatherHerokuApiService) {

    suspend fun getWeatherDataCityList(): MutableLiveData<List<CityContentNetwork>> {

        val data = MutableLiveData<List<CityContentNetwork>>()
        data.value = weatherHerokuApiService.getWeatherDataCityList()

        return data
    }

    suspend fun fetchTempretureForCity(cityName : String): MutableLiveData<CityContentDetailNetwork> {

        val data = MutableLiveData<CityContentDetailNetwork>()
        data.value = weatherHerokuApiService.fetchTempretureForCity(cityName)

        return data
    }


}