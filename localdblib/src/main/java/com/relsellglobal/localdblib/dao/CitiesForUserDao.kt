package com.relsellglobal.localdblib.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.relsellglobal.localdblib.entities.CitiesForUser

@Dao
interface CitiesForUserDao {
    @Insert
    suspend fun insertCityByUser(cityContentDB: CitiesForUser)

    @Update
    suspend fun updateCityContent(cityContentDB: CitiesForUser)

    @Delete
    suspend fun deleteCityContent(cityContentDB: CitiesForUser)

    @Query("SELECT DISTINCT cityName,id From citiesForUser ORDER BY cityName")
    fun getAllCityContent() : LiveData<List<CitiesForUser>>
}