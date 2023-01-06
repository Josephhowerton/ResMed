package com.joseph.resmed.source.impl

import com.joseph.resmed.model.SportsResults
import com.joseph.resmed.network.response.SportsResponse
import com.joseph.resmed.source.Repository
import com.joseph.resmed.source.SportsSource
import com.joseph.resmed.util.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val sportsSource: SportsSource) : Repository  {

    private val results = mutableListOf<SportsResults>()
    private var date: String = ""
    override fun getResultDate(): String = date

    override fun getSportResults(): List<SportsResults> = results

    override suspend fun fetchSportsData(): Result<State> {
        return withContext(Dispatchers.IO)
        {
            try {
                val response = sportsSource.fetchSportsData().awaitResponse()
                response.body()?.let {
                    updateData(it)
                    return@withContext Result.success(State.SUCCESS)
                } ?: throw Exception()
            } catch (e: Exception) {
                return@withContext Result.failure(e)
            }
        }
    }

    private fun updateData(response: SportsResponse) {
        results.clear()
        results.add(response.f1Results.sortedByDescending { it.publicationDate }[0])
        results.add(response.nbaResults.sortedByDescending { it.publicationDate }[0])
        results.add(response.Tennis.sortedByDescending { it.publicationDate }[0])

        date = response.nbaResults.sortedByDescending { it.publicationDate }[0].publicationDate
    }
}