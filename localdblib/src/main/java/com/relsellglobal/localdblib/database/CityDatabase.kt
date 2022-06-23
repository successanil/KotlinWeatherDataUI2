package com.relsellglobal.localdblib.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.relsellglobal.localdblib.dao.CityContentDao
import com.relsellglobal.localdblib.entities.CityContentDB

@Database(entities = [CityContentDB::class],version = 1)
abstract class CityDatabase : RoomDatabase(){
    abstract fun cityContentDao() : CityContentDao
}