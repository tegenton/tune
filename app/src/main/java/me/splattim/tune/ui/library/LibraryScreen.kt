package me.splattim.tune.ui.library

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import me.splattim.tune.R
import me.splattim.tune.ui.components.Grid
import me.splattim.tune.ui.theme.TuneTheme

@Composable
fun LibraryScreen(libraryViewModel: LibraryViewModel = viewModel()) {
    val libraryUiState by libraryViewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            SearchBar(
                libraryViewModel.search,
                { libraryViewModel.updateSearch(it) },
                { libraryViewModel.runSearch() }
            )
        },
        content = {
            if (libraryUiState.grid) {
                Grid(
                    listOf(),
                    Modifier.padding(it)
                )
            } else {

            }
        },
        floatingActionButton = {
            IconButton(onClick = { /*libraryViewModel.shuffle()*/ }) {
                Icon(painterResource(id = R.drawable.ic_shuffle), stringResource(id =  R.string.shuffle))
            }
        },
        bottomBar = {
            PlayerBar()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun LibraryScreenPreview() {
    TuneTheme {
        LibraryScreen()
    }
}