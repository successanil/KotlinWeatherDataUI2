package com.relsellglobal.interfacesgateway.usecases

import com.relsellglobal.interfacesgateway.appinterfaces.repository.IGRepository

class WeatherDataFetchUseCase(var igRepository: IGRepository) {
    suspend fun getWeatherDataList() = igRepository.getWeatherDataCityList()
    suspend fun fetchTempretureForCity(cityName:String) = igRepository.fetchTempretureForCity(cityName)
    suspend fun insertDataIntoCitiesForUser() {
        igRepository.insertDataIntoCitiesForUser()
    }
    fun getAllCitiesForLocalDB() = igRepository.getAllCitiesForLocalDB()
}