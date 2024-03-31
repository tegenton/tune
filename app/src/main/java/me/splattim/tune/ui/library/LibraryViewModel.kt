package me.splattim.tune.ui.library

import android.database.Cursor
import android.database.MatrixCursor
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import me.splattim.tune.data.SongRepository

class LibraryViewModel(private val songRepository: SongRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(LibraryUiState(MatrixCursor(arrayOf("Sample Text"), 0)))
    val uiState: StateFlow<LibraryUiState> = _uiState.asStateFlow()
    var search by mutableStateOf("")
        private set

    fun updateSearch(s: String) {
        search = s
    }

    suspend fun runSearch() {
        _uiState.update { currentState ->
            currentState.copy(search = search)
        }
    }
}

data class LibraryUiState(
    val cursor: Cursor,
    val search: String = "",
    val grid: Boolean = true
)