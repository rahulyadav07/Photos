package com.example.photos.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.photos.databinding.ItemViewBinding
import com.example.photos.models.Images
import com.example.photos.util.imageFromUrl

class ImageAdapter(private val imageList: List<Images>) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = imageList.size



    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item  = imageList[position]
        holder.binding.imageView.imageFromUrl(item.urls.full)
        holder.binding.root.setBackgroundColor(Color.parseColor(item.color))
        holder.binding.description.text = (position+1).toString().plus(". " +item.alt_description)
    }


    class ViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root)

}

