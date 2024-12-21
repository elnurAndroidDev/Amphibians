package com.isayevapps.amphibians.network

import com.isayevapps.amphibians.models.Amphibian
import retrofit2.http.GET

interface AmphibiansApiService {
    @GET("amphibians")
    suspend fun getAmphibians(): List<Amphibian>
}


