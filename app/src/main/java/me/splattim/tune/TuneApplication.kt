package me.splattim.tune

import android.app.Application
import me.splattim.tune.data.room.AppContainer
import me.splattim.tune.data.room.AppDataContainer

class TuneApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}
