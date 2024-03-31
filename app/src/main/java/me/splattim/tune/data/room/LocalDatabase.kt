package me.splattim.tune.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import me.splattim.tune.data.Album
import me.splattim.tune.data.Artist
import me.splattim.tune.data.Song

@Database(entities = [Song::class, Artist::class, Album::class], version = 1, exportSchema = false)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun songDao(): SongDao
    abstract fun artistDao(): ArtistDao
    abstract fun albumDao(): AlbumDao

    companion object {
        @Volatile
        private var Instance: LocalDatabase? = null
        fun getDatabase(context: Context): LocalDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context,
                    klass = LocalDatabase::class.java,
                    "song_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}