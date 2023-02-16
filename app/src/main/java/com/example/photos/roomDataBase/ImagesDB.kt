package com.example.photos.roomDataBase



import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.photos.models.Images

@Database(entities = [Images::class], version = 1)
abstract class ImagesDB :RoomDatabase(){
    abstract fun imageDao() :ImageListDao

}