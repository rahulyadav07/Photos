package com.example.photos

import android.app.Application
import com.example.photos.di.ApplicationComponent
import com.example.photos.di.DaggerApplicationComponent



class ImageApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}