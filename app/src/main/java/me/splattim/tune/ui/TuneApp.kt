package me.splattim.tune.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import me.splattim.tune.ui.library.LibraryScreen
import me.splattim.tune.ui.player.PlayerScreen
import me.splattim.tune.ui.theme.TuneTheme

@Composable
fun TuneApp(appState: TuneAppState = rememberTuneAppState()) {
    NavHost(navController = appState.navController, startDestination = Screen.Library.name) {
        composable(Screen.Library.name) {
            LibraryScreen()
        }
        composable(Screen.Player.name) {
            PlayerScreen()
        }
    }
}

@Preview
@Composable
private fun AppPreview() {
    TuneTheme {
        TuneApp()
    }
}