package me.splattim.tune.data.room

import android.content.Context

interface AppContainer {
    val songRepository: SongRepository
    val artistRepository: ArtistRepository
    val albumRepository: AlbumRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val songRepository: SongRepository by lazy {
        LocalSongRepository(LocalDatabase.getDatabase(context).songDao())
    }
    override val artistRepository: ArtistRepository by lazy {
        LocalArtistRepository(LocalDatabase.getDatabase(context).artistDao())
    }
    override val albumRepository: AlbumRepository by lazy {
        LocalAlbumRepository(LocalDatabase.getDatabase(context).albumDao())
    }
}