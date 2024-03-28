package me.splattim.tune.ui.library

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.splattim.tune.R
import me.splattim.tune.ui.components.ExpandableCard
import me.splattim.tune.ui.theme.TuneTheme

@Composable
fun LibraryGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(88.dp),
        modifier = modifier
    ) {
        item {
            ExpandableCard(drawable = R.drawable.ic_launcher_foreground, name = R.string.dg)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LibraryGridPreview() {
    TuneTheme {
        LibraryGrid()
    }
}