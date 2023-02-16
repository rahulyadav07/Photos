package com.example.photos.di

import android.content.Context
import androidx.room.Room
import com.example.photos.roomDataBase.ImagesDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun getImageData(context:Context) :ImagesDB{
        return Room.databaseBuilder(context , ImagesDB::class.java, "ImagesDB").build()
    }
}