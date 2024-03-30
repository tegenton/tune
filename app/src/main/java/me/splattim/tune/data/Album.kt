package me.splattim.tune.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "albums",
    foreignKeys = [ForeignKey(
        entity = Artist::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("artistId")
    )]
)
data class Album(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val artistId: Int? = null,
    override val name: String,
    override val image: String
) : Cardable