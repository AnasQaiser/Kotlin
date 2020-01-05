package com.servshare.data.models.models

import android.os.Parcel
import android.os.Parcelable
import java.text.SimpleDateFormat
import java.util.*

class Service() : Parcelable{

    var name : String = ""

    var price : Double? = null

    var description : String? = null

    var date : Date ? = null

    var location : String? = null

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()!!
        price = parcel.readValue(Double::class.java.classLoader) as? Double
        description = parcel.readString()
    }

    constructor(name : String, price : Double?, description : String?, date : String?, location : String?) : this(){

        this.name = name
        this.price = price
        this.description = description
        this.location = location

        val sdf = SimpleDateFormat("MM/dd/yyyy", Locale.US)
        this.date = sdf.parse(date)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeValue(price)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Service> {
        override fun createFromParcel(parcel: Parcel): Service {
            return Service(parcel)
        }

        override fun newArray(size: Int): Array<Service?> {
            return arrayOfNulls(size)
        }
    }
}
