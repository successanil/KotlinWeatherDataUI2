package com.relsellglobal.localdblib.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="cityContentDB")
data class CityContentDB (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val cityName:String,
    val weatherData:String
        ) {

}