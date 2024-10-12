package com.example.productlistjob_01nsda

import retrofit2.http.GET

interface apiService {
    @GET("Products")
    suspend fun getProducts():List<Product>

}