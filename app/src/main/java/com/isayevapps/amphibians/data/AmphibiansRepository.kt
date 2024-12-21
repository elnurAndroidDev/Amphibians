package com.isayevapps.amphibians.data

import com.isayevapps.amphibians.network.AmphibiansApiService
import com.isayevapps.amphibians.models.Amphibian

interface AmphibiansRepository {
    suspend fun getAmphibians(): List<Amphibian>
}

class NetWorkAmphibiansRepository(private val amphibianApiService: AmphibiansApiService) :
    AmphibiansRepository {
    override suspend fun getAmphibians(): List<Amphibian> {
        return amphibianApiService.getAmphibians()
    }
}