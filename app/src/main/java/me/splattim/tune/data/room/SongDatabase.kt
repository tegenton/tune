package me.splattim.tune.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import me.splattim.tune.data.Album
import me.splattim.tune.data.Artist
import me.splattim.tune.data.Song

@Database(entities = [Song::class, Artist::class, Album::class], version = 1, exportSchema = false)
abstract class SongDatabase : RoomDatabase() {
    abstract fun songDao(): SongDao
    abstract fun artistDau(): ArtistDao
    abstract fun AlbumDao(): AlbumDao

    companion object {
        @Volatile
        private var Instance: SongDatabase? = null
        fun getDatabase(context: Context): SongDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context,
                    klass = SongDatabase::class.java,
                    "song_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}