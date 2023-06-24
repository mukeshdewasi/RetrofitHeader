package com.example.androidretrofitheader.Model

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("country_name")
    var name:String,
    @SerializedName("country_short_name")
    var shortname:String,
    @SerializedName("country_phone_code")
    var phonecode:Int
)
{
    override fun toString(): String {
        return name
    }
}
