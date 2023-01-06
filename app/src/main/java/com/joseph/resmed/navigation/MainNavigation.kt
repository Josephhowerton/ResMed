package com.joseph.resmed.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joseph.resmed.navigation.Screens.HOME
import com.joseph.resmed.navigation.Screens.RESULTS
import com.joseph.resmed.view.screen.HomeScreen
import com.joseph.resmed.view.screen.SportsResultsScreen


object Screens {
    const val HOME = "home"
    const val RESULTS = "results"
}

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HOME) {
        composable(HOME) { HomeScreen(navController) }
        composable(RESULTS) { SportsResultsScreen(navController) }
    }
}