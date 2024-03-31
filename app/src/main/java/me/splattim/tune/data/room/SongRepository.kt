package me.splattim.tune.data.room

import kotlinx.coroutines.flow.Flow
import me.splattim.tune.data.Album
import me.splattim.tune.data.Artist
import me.splattim.tune.data.Song

interface SongRepository {
    suspend fun insert(song: Song)
    suspend fun update(song: Song)
    suspend fun delete(song: Song)
    fun getArtist(artist: Artist): Flow<List<Song>>
    fun getAlbum(album: Album): Flow<List<Song>>
    fun find(name: String): Flow<List<Song>>
    fun findArtist(artist: Artist, name: String): Flow<List<Song>>
    fun findAlbum(album: Album, name: String): Flow<List<Song>>
    fun getAll(): Flow<List<Song>>
}

class LocalSongRepository(private val songDao: SongDao) : SongRepository {
    override suspend fun insert(song: Song) = songDao.insert(song)

    override suspend fun update(song: Song) = songDao.update(song)

    override suspend fun delete(song: Song) = songDao.delete(song)

    override fun getArtist(artist: Artist): Flow<List<Song>> = songDao.getArtist(artist.id)

    override fun getAlbum(album: Album): Flow<List<Song>> = songDao.getAlbum(album.id)

    override fun find(name: String): Flow<List<Song>> = songDao.find(name)
    override fun findArtist(artist: Artist, name: String): Flow<List<Song>> {
        return if (name.isEmpty()) getArtist(artist) else songDao.findArtist(artist.id, name)
    }

    override fun findAlbum(album: Album, name: String): Flow<List<Song>> {
        return if (name.isEmpty()) getAlbum(album) else songDao.findAlbum(album.id, name)
    }

    override fun getAll(): Flow<List<Song>> = songDao.getAll()
}