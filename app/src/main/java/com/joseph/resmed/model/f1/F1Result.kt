package com.joseph.resmed.model.f1

import com.joseph.resmed.model.SportsResults

data class F1Result(
    val publicationDate: String,
    val seconds: Double,
    val tournament: String,
    val winner: String
) : SportsResults