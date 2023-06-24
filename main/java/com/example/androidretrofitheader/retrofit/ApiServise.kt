package com.example.androidretrofitheader.retrofit

import android.telecom.Call
import com.example.androidretrofitheader.Model.Country
import com.google.android.material.badge.BadgeState.State
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Path

interface ApiServise {
    @GET("countries")
    fun getCountry(@HeaderMap headers :Map<String,String>): retrofit2.Call<List<Country>>
    @GET("states/{country}")
    fun getState(@HeaderMap headers: Map<String, String>, @Path("country")countryName:String):retrofit2.Call<List<com.example.androidretrofitheader.Model.State>>

    fun getcity()
}