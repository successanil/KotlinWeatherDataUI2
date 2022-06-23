package com.relsellglobal.localdblib.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.relsellglobal.localdblib.entities.CityContentDB

@Dao
interface CityContentDao {
    @Insert
    suspend fun insertCityContent(cityContentDB: CityContentDB)

    @Update
    suspend fun updateCityContent(cityContentDB: CityContentDB)

    @Delete
    suspend fun deleteCityContent(cityContentDB: CityContentDB)

    @Query("Select * From cityContentDB")
    fun getCityContent() : LiveData<List<CityContentDB>>
}