package com.joseph.resmed.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.joseph.resmed.source.Repository
import com.joseph.resmed.util.State
import com.joseph.resmed.source.SportsSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    var state = mutableStateOf(State.DEFAULT)

    fun fetchSportsData() {
        state.value = State.LOADING
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.fetchSportsData()
            if(result.isSuccess) {
                state.value = result.getOrDefault(State.DEFAULT)
            }
            else {
                state.value = State.ERROR
            }
        }
    }
}