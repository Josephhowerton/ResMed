package com.joseph.resmed.network.response

import com.joseph.resmed.model.f1.F1Result
import com.joseph.resmed.model.nba.NbaResult
import com.joseph.resmed.model.tennis.TennisResult

data class SportsResponse(
    val Tennis: List<TennisResult>,
    val f1Results: List<F1Result>,
    val nbaResults: List<NbaResult>
)