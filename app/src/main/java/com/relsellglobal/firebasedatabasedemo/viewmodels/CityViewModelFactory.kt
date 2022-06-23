package com.relsellglobal.firebasedatabasedemo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.relsellglobal.firebasedatabasedemo.repository.WeatherDataRepository
import javax.inject.Inject

class CityViewModelFactory @Inject constructor(private val weatherDataRepository: WeatherDataRepository):
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CitiesViewModel(weatherDataRepository) as T
    }
}