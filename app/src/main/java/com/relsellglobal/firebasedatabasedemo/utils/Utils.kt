package com.relsellglobal.firebasedatabasedemo.utils

import android.content.Context
import androidx.work.*
import com.relsellglobal.firebasedatabasedemo.MyApplication
import com.relsellglobal.firebasedatabasedemo.worker.DefCityWorker
import com.relsellglobal.localdblib.entities.CitiesForUser
import com.relsellglobal.modelslib.CityContent
import com.relsellglobal.modelslib.CityContentNetwork
import java.util.concurrent.TimeUnit

class Utils {
    companion object {
        fun mappingCityContentNetworkToCityContent (list : List<CityContentNetwork>) : List<CityContent> {

            var retList = ArrayList<CityContent>()

            for(obj in list){
                var cityContent = CityContent()
                cityContent.cityName = obj.cityName
                cityContent.apiUrl = ""
                retList.add(cityContent)
            }

            return retList

        }

        fun mappingCitiesForUserToCityContent(list:List<CitiesForUser>) : List<CityContent> {
            var retList = ArrayList<CityContent>()
            for(obj in list){
                var cityContent = CityContent()
                cityContent.cityName = obj.cityName
                cityContent.apiUrl = ""
                retList.add(cityContent)
            }
            return retList
        }

        fun setUpWorkerForDefaultCityFetch(context: Context) {
            val constraint = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
            val workerRequest = OneTimeWorkRequest.Builder(DefCityWorker::class.java)
                .setConstraints(constraint).build()

            WorkManager.getInstance(context).enqueue(workerRequest)
        }

    }
}