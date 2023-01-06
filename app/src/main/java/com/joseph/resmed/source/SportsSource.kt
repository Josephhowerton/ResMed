package com.joseph.resmed.source

import com.joseph.resmed.network.response.SportsResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.POST

interface SportsSource {

    suspend fun fetchSportsData() : Call<SportsResponse>
}