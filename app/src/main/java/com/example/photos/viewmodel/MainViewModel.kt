package com.example.photos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.photos.models.Images
import com.example.photos.repo.ImageRepo
import kotlinx.coroutines.launch

class MainViewModel(private val repo: ImageRepo) : ViewModel() {
    val imageLiveData: LiveData<List<Images>>
    get() = repo.imageList

    init {
        viewModelScope.launch {
            repo.getImages()
        }
    }
}