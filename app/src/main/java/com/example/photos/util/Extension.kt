package com.example.photos.util

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.imageFromUrl(url :String){
    Glide.with(this)
        .load(url)
        .into(this)
}
