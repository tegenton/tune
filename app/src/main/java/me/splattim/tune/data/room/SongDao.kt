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
}