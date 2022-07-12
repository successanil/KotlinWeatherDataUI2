package com.relsellglobal.localdblib.di

import android.content.Context
import androidx.room.Room
import com.relsellglobal.localdblib.database.CityDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDBMod(var context: Context) {
    lateinit var database: CityDatabase


    @Singleton
    @Provides
    fun getCityDataBase(): CityDatabase {

        database = Room.databaseBuilder(
            context,
            CityDatabase::class.java,
            "cityDatabase"
        ).build()

        return database
    }
}