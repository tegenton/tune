package me.splattim.tune

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import me.splattim.tune.ui.TuneApp
import me.splattim.tune.ui.theme.TuneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TuneTheme {
                TuneApp()
            }
        }
    }
}
