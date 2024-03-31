package me.splattim.tune.ui.library

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import me.splattim.tune.data.Album
import me.splattim.tune.data.Artist
import me.splattim.tune.data.Cardable
import me.splattim.tune.data.Song
import me.splattim.tune.data.room.AppContainer

class LibraryViewModel(private val container: AppContainer) : ViewModel() {
    val uiState = MutableStateFlow(LibraryUiState())


    private var selectedArtist: Artist? by mutableStateOf(null)
    private var selectedAlbum: Album? by mutableStateOf(null)
    fun filter(cardable: Cardable) {
        if (cardable is Artist) {
            selectedArtist = cardable
        } else if (cardable is Album) {
            selectedAlbum = cardable
        }
        search = ""
    }
    var search by mutableStateOf("")
        private set

    fun updateSearch(s: String) {
        search = s
    }

    fun runSearch() {
        viewModelScope.launch {
            if (selectedArtist == null) {
                container.artistRepository.find(search).collect {
                    uiState.value = LibraryUiState(it)
                }
                container.songRepository.find(search).collect { songList ->
                    uiState.update { it.copy(songList = songList) }
                }
            } else if (selectedAlbum == null) {
                container.albumRepository.findArtist(selectedArtist!!, search).collect {
                    uiState.value = LibraryUiState(it)
                }
                container.songRepository.findArtist(selectedArtist!!, search).collect { songList ->
                    uiState.update { it.copy(songList = songList) }
                }
            } else {
                container.songRepository.findAlbum(selectedAlbum!!, search).collect {
                    uiState.value = LibraryUiState(songList = it)
                }
            }
        }
    }

    fun shuffle() {
        // TODO
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class LibraryUiState(
    val cardableList: List<Cardable> = listOf(),
    val songList: List<Song> = listOf()
)