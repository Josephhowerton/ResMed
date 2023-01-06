package com.joseph.resmed.source.impl

import com.joseph.resmed.network.response.SportsResponse
import com.joseph.resmed.network.service.SportsService
import com.joseph.resmed.source.SportsSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import javax.inject.Inject

class SportsSourceImpl @Inject constructor(private val sportsService: SportsService) : SportsSource {

    override suspend fun fetchSportsData() : Call<SportsResponse> {
        return withContext(Dispatchers.IO) {
            return@withContext sportsService.fetchSportsService()
        }
    }

}