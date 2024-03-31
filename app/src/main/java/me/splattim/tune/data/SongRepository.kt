package me.splattim.tune.data

import kotlinx.coroutines.flow.Flow

interface SongRepository {
    suspend fun insertSong(song: Song)
    suspend fun updateSong(song: Song)
    suspend fun deleteSong(song: Song)
    fun getArtist(artist: Artist): Flow<List<Song>>
    fun getAlbum(album: Album): Flow<List<Song>>
    fun getAll(): Flow<List<Song>>
}