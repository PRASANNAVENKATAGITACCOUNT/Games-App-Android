package com.example.games_app.uis.tictactoe

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.games_app.logic.TicTacToeGameLogic
import com.example.games_app.constants.GameStatus
import com.example.games_app.uis.tictactoe.datasource.TicTacToeGameData


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComputerGameView(context: Context) {

    var gameData by remember {
        mutableStateOf(TicTacToeGameData.data.map { it.toMutableList() }.toMutableList())
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Tic Tac Toe App")
                }
            )
        }
    ) { paddingValue ->
        Column(
            Modifier.padding(paddingValue)
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var text by remember {
                mutableStateOf(GameStatus.GAME_START.toString())
            }
            GameBoardUI(boardData = gameData) { row, col ->
                TicTacToeGameLogic.insertDataComputerGame(gameData,row,col).let {
                        newGameData->
                    gameData = newGameData
                    val gameState= TicTacToeGameLogic.findWinnerInGame(gameData)

                    text = gameState.toString()
                }
            }

            Text(
                text = text,
                style = TextStyle(color = Color.Black,
                    fontSize = 45.sp)
            )

            Button(modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally),
                onClick = {
                    gameData = TicTacToeGameLogic.resetGameData().map { it-> it.toMutableList()  }.toMutableList()
                })
            {
                Text(text = "RESTART GAME" )
            }
        }
    }

}
