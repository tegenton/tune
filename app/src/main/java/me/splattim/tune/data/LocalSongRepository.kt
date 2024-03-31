package me.splattim.tune.data

import kotlinx.coroutines.flow.Flow
import me.splattim.tune.data.room.SongDao

class LocalSongRepository(private val songDao: SongDao) : SongRepository {
    override suspend fun insertSong(song: Song) = songDao.insert(song)

    override suspend fun updateSong(song: Song) = songDao.update(song)

    override suspend fun deleteSong(song: Song) = songDao.delete(song)

    override fun getArtist(artist: Artist): Flow<List<Song>> = songDao.getArtist(artist.id)

    override fun getAlbum(album: Album): Flow<List<Song>> = songDao.getAlbum(album.id)

    override fun getAll(): Flow<List<Song>> = songDao.getAll()
}