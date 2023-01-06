package com.joseph.resmed.view.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.joseph.resmed.model.f1.F1Result
import com.joseph.resmed.model.nba.NbaResult
import com.joseph.resmed.model.tennis.TennisResult
import com.joseph.resmed.view.Toolbar
import com.joseph.resmed.viewmodel.SportsViewModel

@Composable
fun SportsResultsScreen(navController: NavController) {

    val viewModel: SportsViewModel = hiltViewModel()
    val results = remember { viewModel.sportsResult }
    val date = remember { viewModel.resultDate }
    Scaffold(topBar = { Toolbar(date, navController) }) {
        LazyColumn (verticalArrangement = Arrangement.spacedBy(2.dp)) {
            items(results) { sport ->
                when(sport) {
                    is F1Result -> FOneItem(sport)
                    is NbaResult -> NBAItem(sport)
                    is TennisResult -> TennisItem(sport)
                }
            }
        }
    }
}

@Composable
private fun FOneItem(f1Result: F1Result) {
    Card(elevation = 4.dp) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp)) {
            Text(text = "Tournament: ${f1Result.tournament}", Modifier.padding(5.dp))
            Text(text = "Winner: ${f1Result.winner}", Modifier.padding(5.dp))
            Text(text = "Seconds: ${f1Result.seconds}", Modifier.padding(5.dp))
        }
    }
}

@Composable
private fun TennisItem(tennisResult: TennisResult) {
    Card(elevation = 4.dp) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp)) {
            Text(text = "Tournament: ${tennisResult.tournament}", Modifier.padding(5.dp))
            Text(text = "Winner: ${tennisResult.winner}", Modifier.padding(5.dp))
            Text(text = "Looser: ${tennisResult.looser}", Modifier.padding(5.dp))
            Text(text = "Number Of Sets: ${tennisResult.numberOfSets}", Modifier.padding(5.dp))
        }
    }
}

@Composable
private fun NBAItem(nbaResult: NbaResult) {
    Card(elevation = 4.dp) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp)) {
            Text(text = "Tournament: ${nbaResult.tournament}", Modifier.padding(5.dp))
            Text(text = "Winner: ${nbaResult.winner}", Modifier.padding(5.dp))
            Text(text = "Looser: ${nbaResult.looser}", Modifier.padding(5.dp))
            Text(text = "MVP: ${nbaResult.mvp}", Modifier.padding(5.dp))
            Text(text = "Game Number: ${nbaResult.gameNumber}", Modifier.padding(5.dp))
        }
    }
}