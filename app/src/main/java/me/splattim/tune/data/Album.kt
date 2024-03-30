package me.splattim.tune.data

import androidx.compose.ui.graphics.painter.Painter
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "albums")
data class Album(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    override val name: String,
    override val image: Painter
) : Cardable