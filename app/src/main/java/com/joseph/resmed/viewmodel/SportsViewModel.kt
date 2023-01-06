package com.joseph.resmed.viewmodel

import androidx.lifecycle.ViewModel
import com.joseph.resmed.model.SportsResults
import com.joseph.resmed.source.Repository
import com.joseph.resmed.source.SportsSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SportsViewModel @Inject constructor(repository: Repository): ViewModel() {

    val sportsResult = repository.getSportResults()
    val resultDate = repository.getResultDate()

}