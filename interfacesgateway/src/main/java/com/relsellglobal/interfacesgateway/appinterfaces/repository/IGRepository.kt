package com.relsellglobal.interfacesgateway.appinterfaces.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.relsellglobal.localdblib.entities.CitiesForUser
import com.relsellglobal.modelslib.CityContentDetailNetwork
import com.relsellglobal.modelslib.CityContentNetwork

interface IGRepository {
    suspend fun getWeatherDataCityList(): MutableLiveData<List<CityContentNetwork>>
    suspend fun fetchTempretureForCity(cityName : String): MutableLiveData<CityContentDetailNetwork>
    suspend fun insertDataIntoCitiesForUserFromNetwork()
    suspend fun insertDataIntoCitiesForUser()
    suspend fun insertDataIntoCityDatabase()
    fun getAllCitiesForLocalDB() : LiveData<List<CitiesForUser>>
}