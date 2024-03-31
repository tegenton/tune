package me.splattim.tune.data

import android.content.Context
import me.splattim.tune.data.room.SongDatabase

interface AppContainer {
    val songRepository: SongRepository
}

class AppDataContainer(private val context: Context) : AppContainer{
    override val songRepository: SongRepository by lazy {
        LocalSongRepository(SongDatabase.getDatabase(context).songDao())
    }

}