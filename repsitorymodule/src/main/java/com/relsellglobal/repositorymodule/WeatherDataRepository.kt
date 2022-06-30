package com.relsellglobal.repositorymodule



import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.relsellglobal.interfacesgateway.network.IGApiService
import com.relsellglobal.interfacesgateway.repository.IGRepository
import com.relsellglobal.localdblib.database.CityDatabase
import com.relsellglobal.localdblib.entities.CitiesForUser
import com.relsellglobal.localdblib.entities.CityContentDB
import com.relsellglobal.modelslib.CityContentDetailNetwork
import com.relsellglobal.modelslib.CityContentNetwork
import javax.inject.Inject

class WeatherDataRepository @Inject constructor(private val weatherHerokuApiService: IGApiService,private val
cityDatabase: CityDatabase) : IGRepository {

    override suspend fun getWeatherDataCityList(): MutableLiveData<List<CityContentNetwork>> {

        val data = MutableLiveData<List<CityContentNetwork>>()
        data.value = weatherHerokuApiService.getWeatherDataCityList()

        return data
    }

    override suspend fun fetchTempretureForCity(cityName : String): MutableLiveData<CityContentDetailNetwork> {

        val data = MutableLiveData<CityContentDetailNetwork>()
        data.value = weatherHerokuApiService.fetchTempretureForCity(cityName)

        return data
    }

    override suspend fun insertDataIntoCityDatabase() {
        cityDatabase.cityContentDao().insertCityContent(CityContentDB(0,"gurgaon","{}"))
    }

    override suspend fun insertDataIntoCitiesForUser() {
        cityDatabase.citiesForUserDao().insertCityByUser(CitiesForUser(0,"jamshedpur"))
    }

    override suspend fun insertDataIntoCitiesForUserFromNetwork() {
        var result = weatherHerokuApiService.getWeatherDataCityListForWorkManager()

        if(result != null && !result.isEmpty()) {
            for(cityContentNetwork in result){
                cityDatabase.citiesForUserDao().insertCityByUser(CitiesForUser(0,cityContentNetwork.cityName))
            }

        }

    }

    override fun getAllCitiesForLocalDB() : LiveData<List<CitiesForUser>> {
        var list = cityDatabase.citiesForUserDao().getAllCityContent()
        return list
    }


}