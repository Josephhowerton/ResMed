package com.joseph.resmed.source

import com.joseph.resmed.model.SportsResults
import com.joseph.resmed.util.State

interface Repository {
    fun getResultDate() : String
    fun getSportResults() : List<SportsResults>
    suspend fun fetchSportsData() : Result<State>
}