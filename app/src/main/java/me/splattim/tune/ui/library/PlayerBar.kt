package me.splattim.tune.ui.library

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.splattim.tune.R
import me.splattim.tune.ui.theme.TuneTheme

@Composable
fun PlayerBar(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
       Image(
           painter = painterResource(id = R.drawable.ic_launcher_background),
           contentDescription = null,
           modifier = Modifier.size(56.dp)
       )
       Column(
           horizontalAlignment = Alignment.CenterHorizontally,
           modifier = Modifier.weight(1f)
       ) {
           Row {
               Text(stringResource(id = R.string.dg))
               Text(" - ")
               Text(stringResource(id = R.string.album))
           }
           LinearProgressIndicator(
               progress = { 0.5f },
               modifier = Modifier.fillMaxWidth(),
           )
       }
       Icon(
           Icons.Default.PlayArrow,
           "play",
           modifier = Modifier.size(56.dp)
       )
    }
}

@Preview(showBackground = true)
@Composable
fun PlayerBarPreview() {
    TuneTheme {
        PlayerBar()
    }
}