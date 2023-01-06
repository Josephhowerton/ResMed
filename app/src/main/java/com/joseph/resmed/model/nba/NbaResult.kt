package com.joseph.resmed.model.nba

import com.joseph.resmed.model.SportsResults

data class NbaResult(
    val gameNumber: Int,
    val looser: String,
    val mvp: String,
    val publicationDate: String,
    val tournament: String,
    val winner: String
) : SportsResults