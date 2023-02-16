package com.example.photos.roomDataBase

import androidx.room.*
import com.example.photos.models.Images

@Dao
interface ImageListDao {
    @Query("SELECT * FROM ImagesList")
    suspend fun getData(): List<Images>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(data: List<Images>)

    @Delete
    suspend fun deleteData(data: List<Images>)
}
