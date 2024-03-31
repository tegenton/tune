package me.splattim.tune.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import me.splattim.tune.TuneApplication
import me.splattim.tune.ui.library.LibraryViewModel
import me.splattim.tune.ui.player.PlayerViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            LibraryViewModel(tuneApplication().container.songRepository)
        }
        initializer {
            PlayerViewModel()
        }
    }
}

fun CreationExtras.tuneApplication(): TuneApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TuneApplication)