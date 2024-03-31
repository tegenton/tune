package me.splattim.tune.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import me.splattim.tune.data.Artist

@Dao
interface ArtistDao {
    @Insert
    suspend fun insert(artist: Artist)
    @Update
    suspend fun update(artist: Artist)
    @Delete
    suspend fun delete(artist: Artist)
    @Query("SELECT * from artists where name LIKE :name")
    fun find(name: String): Flow<List<Artist>>
    @Query("SELECT * from artists")
    fun getAll(): Flow<List<Artist>>
}
