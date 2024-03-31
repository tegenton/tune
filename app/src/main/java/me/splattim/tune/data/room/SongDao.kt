package me.splattim.tune.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import me.splattim.tune.data.Song

@Dao
interface SongDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(song: Song)

    @Update
    suspend fun update(song: Song)

    @Delete
    suspend fun delete(song: Song)

    @Query("SELECT * from songs where artistId = :artistId")
    fun getArtist(artistId: Int): Flow<List<Song>>

    @Query("SELECT * from songs where albumId = :albumId")
    fun getAlbum(albumId: Int): Flow<List<Song>>

    @Query("SELECT * from songs where name LIKE :name")
    fun find(name: String): Flow<List<Song>>
    @Query("SELECT * from songs where artistId = :artistId AND name LIKE :name")
    fun findArtist(artistId: Int, name: String): Flow<List<Song>>
    @Query("SELECT * from songs where albumId = :albumId AND name LIKE :name")
    fun findAlbum(albumId: Int, name: String): Flow<List<Song>>

    @Query("SELECT * from songs")
    fun getAll(): Flow<List<Song>>
}