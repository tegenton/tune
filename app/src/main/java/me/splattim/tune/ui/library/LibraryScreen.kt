package me.splattim.tune.ui.library

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import me.splattim.tune.R
import me.splattim.tune.ui.AppViewModelProvider
import me.splattim.tune.ui.components.ExpandableCardLazyGrid
import me.splattim.tune.ui.theme.TuneTheme

@Composable
fun LibraryScreen(libraryViewModel: LibraryViewModel = viewModel(factory = AppViewModelProvider.Factory)) {
    val libraryUiState by libraryViewModel.uiState.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            SearchBar(
                libraryViewModel.search,
                { libraryViewModel.updateSearch(it) },
                { coroutineScope.launch { libraryViewModel.runSearch() } }
            )
        },
        content = {
            ExpandableCardLazyGrid(
                listOf(),
                {},
                Modifier.padding(it)
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*libraryViewModel.shuffle()*/ },
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