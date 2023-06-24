package com.example.androidretrofitheader.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object{

        var retrofit:Retrofit?=null

        fun init():ApiServise{
                if(retrofit==null){

                    retrofit=Retrofit.Builder()
                        .baseUrl("https://www.universal-tutorial.com/api/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

                }
         return   retrofit!!.create(ApiServise::class.java)
        }

        fun getHeaderMap():MutableMap<String,String>{
          return mutableMapOf(
              "Accept" to "application/json",
              "Authorization" to "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7InVzZXJfZW1haWwiOiJtdWtlc2hkZXdhc2kyMjdAZ21haWwuY29tIiwiYXBpX3Rva2VuIjoiMEx2UzBIUE1vbEN1STZUTFZsbmROTkVKRVhsSXctMjRwVlp0SEp0LUEtTGVCOEVfZHlDcDAzNDk3akJNMy1rRmhnOCJ9LCJleHAiOjE2ODMwMTU1NjZ9.ofMs7ZGnLEhiXiGSqQPI4Eu3r0PbDTATSUXbn8ib1iE"
          )

        }

    }
}