package com.relsellglobal.firebasedatabasedemo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.relsellglobal.interfacesgateway.appinterfaces.repository.IGRepository
import com.relsellglobal.interfacesgateway.usecases.WeatherDataFetchUseCase
import com.relsellglobal.localdblib.entities.CitiesForUser
import com.relsellglobal.modelslib.CityContentDetailNetwork
import com.relsellglobal.modelslib.CityContentNetwork


class CitiesViewModel(private val weatherDataRepository: IGRepository) : ViewModel() {


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
        var weatherDataFetchUseCase = WeatherDataFetchUseCase(weatherDataRepository)
        citiesContent = weatherDataFetchUseCase.getWeatherDataList()
    }

    private suspend fun fetchTempretureForCity(cityName: String) {
        var weatherDataFetchUseCase = WeatherDataFetchUseCase(weatherDataRepository)
        cityContentNetworkDetail = weatherDataFetchUseCase.fetchTempretureForCity(cityName)
    }

    suspend fun insertDataIntoCityDatabase() {
        var weatherDataFetchUseCase = WeatherDataFetchUseCase(weatherDataRepository)
        weatherDataFetchUseCase.insertDataIntoCitiesForUser()
    }

    suspend fun insertDataIntoCitiesForUser() {
        var weatherDataFetchUseCase = WeatherDataFetchUseCase(weatherDataRepository)
        weatherDataFetchUseCase.insertDataIntoCitiesForUser()
    }

    fun getAllCitiesForLocalDB() : LiveData<List<CitiesForUser>> {
        var weatherDataFetchUseCase = WeatherDataFetchUseCase(weatherDataRepository)
        return weatherDataFetchUseCase.getAllCitiesForLocalDB()
    }

}