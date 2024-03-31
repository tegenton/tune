package me.splattim.tune.data.room

import kotlinx.coroutines.flow.Flow
import me.splattim.tune.data.Artist

interface ArtistRepository {
    suspend fun insert(artist: Artist)
    suspend fun update(artist: Artist)
    suspend fun delete(artist: Artist)

    fun find(name: String): Flow<List<Artist>>
    fun getAll(): Flow<List<Artist>>
}
class LocalArtistRepository(private val artistDao: ArtistDao) : ArtistRepository {
    override suspend fun insert(artist: Artist) = artistDao.insert(artist)

    override suspend fun update(artist: Artist) = artistDao.update(artist)

    override suspend fun delete(artist: Artist) = artistDao.delete(artist)
    override fun find(name: String): Flow<List<Artist>> {
        return if (name.isEmpty()) getAll() else artistDao.find(name)
    }
    override fun getAll(): Flow<List<Artist>> = artistDao.getAll()

}