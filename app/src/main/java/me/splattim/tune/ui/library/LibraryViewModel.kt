package me.splattim.tune.ui.library

import android.database.MatrixCursor
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LibraryViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LibraryUiState(MatrixCursor(arrayOf("Sample Text"), 0)))
    val uiState: StateFlow<LibraryUiState> = _uiState.asStateFlow()
    var search by mutableStateOf("")
        private set

    fun updateSearch(s: String) {
        search = s
    }

    fun runSearch() {
        _uiState.update { currentState ->
            currentState.copy(search = search)
        }
    }
}