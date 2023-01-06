package com.joseph.resmed.view.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.joseph.resmed.navigation.Screens
import com.joseph.resmed.util.State
import com.joseph.resmed.view.util.ErrorDialog
import com.joseph.resmed.view.util.LoadingScreen
import com.joseph.resmed.viewmodel.HomeViewModel


@Composable
fun HomeScreen(navController: NavController) {

    val viewModel = hiltViewModel<HomeViewModel>()
    val state = remember { viewModel.state }
    val showErrorDialog = remember { mutableStateOf(false) }
    val showLoading = remember { mutableStateOf(false) }

    DefaultScreen(viewModel, showLoading, showErrorDialog)

    when(state.value) {
        State.LOADING -> showLoading.value = true
        State.SUCCESS -> {
            state.value = State.DEFAULT
            navController.navigate(Screens.RESULTS)
        }
        State.ERROR -> {
            showLoading.value = false
            showErrorDialog.value = true
        }
        State.DEFAULT -> {
            showLoading.value = false
            showErrorDialog.value = false
        }
    }
}

@Composable
private fun DefaultScreen(viewModel: HomeViewModel, showLoading: MutableState<Boolean>, showErrorDialog: MutableState<Boolean>) {
    if(showErrorDialog.value) {
        ErrorDialog("Oops!", "We could not retrieve your results") {
            showErrorDialog.value = false
        }
    }

    if(showLoading.value) {
        LoadingScreen()
    }else{
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { viewModel.fetchSportsData() }) {
                Text(text = "Results")
            }
        }
    }

}