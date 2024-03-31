package me.splattim.tune.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.splattim.tune.data.Album
import me.splattim.tune.data.Cardable
import me.splattim.tune.ui.theme.TuneTheme

@Composable
fun ExpandableCardLazyGrid(
    gridContent: List<Cardable>,
    onSelect: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(88.dp), // TODO
        modifier = modifier.fillMaxSize()
    ) {
        items(gridContent) {
            ExpandableCard(it, onSelect)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GridPreview() {
    val album = Album(
        name = "Sample Text"
    )
    TuneTheme {
        ExpandableCardLazyGrid(listOf(album, album), {})
    }
}