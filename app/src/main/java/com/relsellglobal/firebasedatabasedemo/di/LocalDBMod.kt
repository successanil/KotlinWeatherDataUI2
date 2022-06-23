package com.relsellglobal.firebasedatabasedemo.di

import android.content.Context
import androidx.room.Room
import com.relsellglobal.firebasedatabasedemo.MyApplication
import com.relsellglobal.localdblib.database.CityDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDBMod(applicationClass: MyApplication) {

    var applicationClass = applicationClass
    lateinit var database: CityDatabase


    @Singleton
    @Provides
    fun getCityDataBase(): CityDatabase {

        database = Room.databaseBuilder(
            applicationClass,
            CityDatabase::class.java,
            "cityDatabase"
        ).build()

        return database
    }
}