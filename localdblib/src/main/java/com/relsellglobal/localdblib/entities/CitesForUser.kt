package com.relsellglobal.localdblib.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="citiesForUser")
data class CitiesForUser (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val cityName:String)
    {

}