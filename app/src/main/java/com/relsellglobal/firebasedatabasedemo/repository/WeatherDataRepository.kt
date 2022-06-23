package com.relsellglobal.firebasedatabasedemo.repository



import androidx.lifecycle.MutableLiveData
import com.relsellglobal.localdblib.database.CityDatabase
import com.relsellglobal.localdblib.entities.CityContentDB
import com.relsellglobal.modelslib.CityContentDetailNetwork
import com.relsellglobal.modelslib.CityContentNetwork
import com.relsellglobal.networklib.apiservice.WeatherHerokuApiService
import javax.inject.Inject

class WeatherDataRepository @Inject constructor(private val weatherHerokuApiService: WeatherHerokuApiService,private val
cityDatabase: CityDatabase) {

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

    suspend fun insertDataIntoCityDatabase() {
        cityDatabase.cityContentDao().insertCityContent(CityContentDB(0,"gurgaon","{}"))
    }


}