package com.joseph.resmed.network.service

import com.joseph.resmed.network.response.SportsResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.POST

interface SportsService {
    companion object {
        const val BASE_URL = "https://restest.free.beeceptor.com"
    }

    @POST("/results")
    fun fetchSportsService() : Call<SportsResponse>
}