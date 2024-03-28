package me.splattim.tune.ui.library

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
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
            LibraryGrid(Modifier.padding(it))
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