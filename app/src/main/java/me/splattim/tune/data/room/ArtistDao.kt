package me.splattim.tune.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import me.splattim.tune.data.Artist

@Dao
interface ArtistDao {
    @Insert
    suspend fun insert(artist: Artist)
    @Update
    suspend fun update(artist: Artist)
    @Delete
    suspend fun delete(artist: Artist)
}
