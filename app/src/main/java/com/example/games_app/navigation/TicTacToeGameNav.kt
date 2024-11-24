package com.example.games_app.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.games_app.constants.TicTacToeNavConst
import com.example.games_app.uis.tictactoe.ComputerGameView
import com.example.games_app.uis.tictactoe.FriendGameView
import com.example.games_app.uis.tictactoe.HomeScree

@Composable
fun NavigationOfTicTacToeGame(context: Context,) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = TicTacToeNavConst.HomeScreenPath.navPath) {
        composable(TicTacToeNavConst.HomeScreenPath.navPath){
            HomeScree(){ path->
                navController.navigate(path)
            }
        }
        composable(TicTacToeNavConst.FriendTicTacToePathConst.navPath){
            FriendGameView(context=context)
        }
        composable(TicTacToeNavConst.ComputerTicTacToePathConst.navPath){
            ComputerGameView(context = context)
        }
    }
}