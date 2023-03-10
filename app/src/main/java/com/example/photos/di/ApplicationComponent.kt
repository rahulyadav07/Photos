package com.example.photos.di

import android.content.Context
import com.example.photos.activity.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton  @Component(modules = [NetworkModule::class, DataBaseModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context) :ApplicationComponent
    }
}