package me.splattim.tune.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artists")
data class Artist(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    override val name: String,
    override val image: String? = null
) : Cardable