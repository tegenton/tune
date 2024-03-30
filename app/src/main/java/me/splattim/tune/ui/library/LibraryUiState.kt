package me.splattim.tune.ui.library

import android.database.Cursor

data class LibraryUiState(
    val cursor: Cursor,
    val search: String = "",
    val grid: Boolean = true
)