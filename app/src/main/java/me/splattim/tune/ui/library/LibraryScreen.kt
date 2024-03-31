package me.splattim.tune.ui.library

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import me.splattim.tune.ui.AppViewModelProvider
import me.splattim.tune.ui.components.ExpandableCardLazyGrid
import me.splattim.tune.ui.components.SongRow
import me.splattim.tune.ui.theme.TuneTheme

@Composable
fun LibraryScreen(libraryViewModel: LibraryViewModel = viewModel(factory = AppViewModelProvider.Factory)) {
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
            if (libraryUiState.cardableList.isNotEmpty()) {
                ExpandableCardLazyGrid(
                    libraryUiState.cardableList,
                    { cardable ->
                        libraryViewModel.filter(cardable)
                    },
                    Modifier.padding(it)
                )
            } else {
                LazyColumn(
                    Modifier.padding(it)
                ) {
                    items(libraryUiState.songList) {
                        SongRow(it)
                    }
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { libraryViewModel.shuffle() },
                shape = MaterialTheme.shapes.medium
            ) {
                Icon(painterResource(id = R.drawable.ic_shuffle), stringResource(R.string.shuffle))
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