package com.relsellglobal.uiphonemod.di

import android.content.Context
import androidx.room.Room
import com.relsellglobal.localdblib.database.CityDatabase
import com.relsellglobal.uiphonemod.UiApplicationClass
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDBMod(applicationClass: UiApplicationClass) {

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