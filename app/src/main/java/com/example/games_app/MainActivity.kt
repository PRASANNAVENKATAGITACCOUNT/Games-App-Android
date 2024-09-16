package com.example.games_app


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import com.example.games_app.ui.theme.TicTacToeAppTheme
import com.example.games_app.uis.tictactoe.NavigationOfTicTacToeGame


class MainActivity : ComponentActivity() {
  companion object{

      //tic tac toe game data
      val data = listOf(
          mutableListOf(" "," "," "),
          mutableListOf(" "," "," "),
          mutableListOf(" "," "," ")
      )
  }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TicTacToeAppTheme {
               NavigationOfTicTacToeGame(context = this)
            }
        }
    }


}







@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TicTacToeAppTheme {

    }
}