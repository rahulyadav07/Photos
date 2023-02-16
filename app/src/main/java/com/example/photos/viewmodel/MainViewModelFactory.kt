package com.example.photos.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.photos.repo.ImageRepo
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val repo: ImageRepo) :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repo) as T
    }
}