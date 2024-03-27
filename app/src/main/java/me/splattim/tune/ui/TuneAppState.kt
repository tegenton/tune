package me.splattim.tune.ui

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

enum class Screen() {
    Library,
}

@Composable
fun rememberTuneAppState(
    navController: NavHostController = rememberNavController(),
    context: Context = LocalContext.current
)  = remember(navController, context) {
    TuneAppState(navController, context)
}

class TuneAppState(
    val navController: NavHostController,
    private val context: Context
) {

}
