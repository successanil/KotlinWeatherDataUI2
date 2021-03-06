package com.relsellglobal.modelslib

import android.os.Parcel
import android.os.Parcelable

class CityContent() : Parcelable{

    var cityName: String? = null
    var apiUrl: String? = null

    constructor(parcel: Parcel) : this() {
        cityName = parcel.readString()
        apiUrl = parcel.readString()
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(cityName)
        dest?.writeString(apiUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CityContent> {
        override fun createFromParcel(parcel: Parcel): CityContent {
            return CityContent(parcel)
        }

        override fun newArray(size: Int): Array<CityContent?> {
            return arrayOfNulls(size)
        }
    }

    override fun equals(other: Any?): Boolean {
        try {
            return this.cityName == (other as CityContent).cityName
        } catch (e:Exception) {
            return false
        }
    }


}