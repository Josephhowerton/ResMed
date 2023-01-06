package com.joseph.resmed.model.tennis

import com.joseph.resmed.model.SportsResults

data class TennisResult(
    val looser: String,
    val numberOfSets: Int,
    val publicationDate: String,
    val tournament: String,
    val winner: String
) : SportsResults