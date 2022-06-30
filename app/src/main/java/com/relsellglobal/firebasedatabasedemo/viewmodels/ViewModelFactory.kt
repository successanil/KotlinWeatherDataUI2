package com.relsellglobal.firebasedatabasedemo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.relsellglobal.repositorymodule.WeatherDataRepository
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val weatherDataRepository: WeatherDataRepository):
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass == CitiesViewModel::class.java) {
            return CitiesViewModel(weatherDataRepository) as T
        } else {
            throw IllegalStateException("Unknown Entity")
        }

    }
}