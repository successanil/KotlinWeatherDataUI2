package com.relsellglobal.firebasedatabasedemo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.relsellglobal.firebasedatabasedemo.repository.WeatherDataRepository
import com.relsellglobal.modelslib.CityContentDetailNetwork
import com.relsellglobal.modelslib.CityContentNetwork


class CitiesViewModel(private val weatherDataRepository: WeatherDataRepository) : ViewModel() {


    private lateinit var citiesContent: MutableLiveData<List<CityContentNetwork>>

    private lateinit var cityContentNetworkDetail: MutableLiveData<CityContentDetailNetwork>


    suspend fun getCitiesList(): LiveData<List<CityContentNetwork>> {
        if (!::citiesContent.isInitialized) {
            citiesContent = MutableLiveData()
            loadCities()
        }
        return citiesContent
    }

    suspend fun getCityDetail(cityName: String): LiveData<CityContentDetailNetwork> {
//        if (!::cityContentNetworkDetail.isInitialized) {
        cityContentNetworkDetail = MutableLiveData()
        fetchTempretureForCity(cityName)
//        }
        return cityContentNetworkDetail
    }


    private suspend fun loadCities() {
        citiesContent = weatherDataRepository.getWeatherDataCityList()
    }

    private suspend fun fetchTempretureForCity(cityName: String) {
        cityContentNetworkDetail = weatherDataRepository.fetchTempretureForCity(cityName)
    }

    suspend fun insertDataIntoCityDatabase() {
        weatherDataRepository.insertDataIntoCityDatabase()
    }
}