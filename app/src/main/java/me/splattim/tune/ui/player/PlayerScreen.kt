package me.splattim.tune.ui.player

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import me.splattim.tune.R
import me.splattim.tune.ui.theme.TuneTheme


@Composable
fun PlayerScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = ""
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PlayerPreview() {
    TuneTheme {
        PlayerScreen()
    }
}