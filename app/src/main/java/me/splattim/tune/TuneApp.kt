package me.splattim.tune

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import me.splattim.tune.ui.navigation.TuneNavHost
import me.splattim.tune.ui.theme.TuneTheme

@Composable
fun TuneApp(navController: NavHostController = rememberNavController()) {
    TuneNavHost(navController = navController)
}

@Preview
@Composable
private fun AppPreview() {
    TuneTheme {
        TuneApp()
    }
}