package me.splattim.tune.data.room

import kotlinx.coroutines.flow.Flow
import me.splattim.tune.data.Album
import me.splattim.tune.data.Artist

interface AlbumRepository {
    suspend fun insert(album: Album)
    suspend fun update(album: Album)
    suspend fun delete(album: Album)
    fun getArtist(artist: Artist): Flow<List<Album>>

    fun find(name: String): Flow<List<Album>>

    fun findArtist(artist: Artist, name: String): Flow<List<Album>>
    fun getAll(): Flow<List<Album>>
}

class LocalAlbumRepository(private val albumDao: AlbumDao) : AlbumRepository {
    override suspend fun insert(album: Album) = albumDao.insert(album)

    override suspend fun update(album: Album) = albumDao.update(album)

    override suspend fun delete(album: Album) = albumDao.delete(album)

    override fun getArtist(artist: Artist): Flow<List<Album>> = albumDao.getArtist(artist.id)

    override fun find(name: String): Flow<List<Album>> {
        return if (name.isEmpty()) getAll() else albumDao.find(name)
    }
    override fun findArtist(artist: Artist, name: String): Flow<List<Album>> {
        return if (name.isEmpty()) getArtist(artist) else albumDao.findArtist(artist.id, name)
    }

    override fun getAll(): Flow<List<Album>> = albumDao.getAll()
}