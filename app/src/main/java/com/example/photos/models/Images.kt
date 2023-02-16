package com.example.photos.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ImagesList")
data class Images(
    @PrimaryKey
    val id :String,
    val alt_description: String?  = "",
    val color: String,
    @Embedded
    val urls: Urls,
)