package com.example.productlistjob_01nsda

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object apiInstance {


    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.escuelajs.co/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())

        .build()



    val apiService = retrofit.create(apiService::class.java)

}