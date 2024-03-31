package me.splattim.tune.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.splattim.tune.data.Song
import me.splattim.tune.ui.theme.TuneTheme

@Composable
fun SongRow(song: Song, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {

    }
}
@Preview(showBackground = true)
@Composable
fun SongRowPreview() {
    TuneTheme {
        SongRow(Song(name = "Sample Name"))
    }
}