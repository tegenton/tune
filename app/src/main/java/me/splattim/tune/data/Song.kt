package me.splattim.tune.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "songs",
    foreignKeys = [
        ForeignKey(
            entity = Artist::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("artistId")
        ),
        ForeignKey(
            entity = Album::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("albumId")
        )
    ]
)
data class Song(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val artistId: Int? = null,
    val albumId: Int? = null
)