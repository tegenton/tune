package me.splattim.tune.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import me.splattim.tune.ui.library.LibraryScreen
import me.splattim.tune.ui.player.PlayerScreen

@Composable
fun TuneNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Library.name) {
        composable(Screen.Library.name) {
            LibraryScreen()
        }
        composable(Screen.Player.name) {
            PlayerScreen()
        }
    }
}

enum class Screen() {
    Library,
    Player,
}