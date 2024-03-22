package me.splattim.tune.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import me.splattim.tune.ui.library.Library
import me.splattim.tune.ui.theme.TuneTheme

@Composable
fun TuneApp(appState: TuneAppState = rememberTuneAppState()) {
    NavHost(navController = appState.navController, startDestination = Screen.Library.route) {
        composable(Screen.Library.route) {
            Library()
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