package me.splattim.tune.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import me.splattim.tune.data.Album

@Dao
interface AlbumDao {
    @Insert
    suspend fun insert(album: Album)
    @Update
    suspend fun update(album: Album)
    @Delete
    suspend fun delete(album: Album)
    @Query("SELECT * from albums where artistId = :artistId")
    fun getArtist(artistId: Int): Flow<List<Album>>

    @Query("SELECT * from albums where name LIKE :name")
    fun find(name: String): Flow<List<Album>>
    @Query("SELECT * from albums where artistId = :artistId AND name LIKE :name")
    fun findArtist(artistId: Int, name: String): Flow<List<Album>>
    @Query("SELECT * from albums")
    fun getAll(): Flow<List<Album>>
}
