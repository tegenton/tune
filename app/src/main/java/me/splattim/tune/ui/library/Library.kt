package me.splattim.tune.ui.library

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.splattim.tune.R
import me.splattim.tune.ui.theme.TuneTheme

@Composable
fun Library() {
    Scaffold(
        topBar = {
            SearchBar()
        },
        content = {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(88.dp),
                modifier = Modifier.padding(it)
            ) {
                item {
                    InfoElement(drawable = R.drawable.dg, name = R.string.dg)
                }
            }
        },
        bottomBar = {
            PlayerBar()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun LibraryPreview() {
    TuneTheme {
        Library()
    }
}