package com.example.photos.repo

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.photos.models.Images
import com.example.photos.retrofit.ImageAPI
import com.example.photos.roomDataBase.ImagesDB
import com.example.photos.util.Utils
import javax.inject.Inject

class ImageRepo @Inject constructor(private val imageAPI: ImageAPI, private val imaegDB: ImagesDB, val context: Context) {

    private val _imageList = MutableLiveData<List<Images>>()
    val imageList: LiveData<List<Images>>
        get() = _imageList

    suspend fun getImages() {

        if(Utils.isInternetAvailable(context)){
            val result = imageAPI.getResult("1", "30", "-QyQ414jzfzBttOvKIDJBNleloBcrjzpSR2dR2fr0r8")
            if(result.isSuccessful && result.body()!=null){
                _imageList.postValue(result.body())
                imaegDB.imageDao().insertData(result.body()!!)
            }
        }else{
            _imageList.postValue(imaegDB.imageDao().getData())
        }



    }
}