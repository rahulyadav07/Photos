package com.example.photos.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.photos.ImageApplication
import com.example.photos.adapter.ImageAdapter
import com.example.photos.databinding.ActivityMainBinding
import com.example.photos.viewmodel.MainViewModel
import com.example.photos.viewmodel.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var model: MainViewModel
    @Inject
    lateinit var modelFactory: MainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as ImageApplication).applicationComponent.inject(this)
        model = ViewModelProvider(this, modelFactory).get(MainViewModel::class.java)
        initView()
    }
    private fun initView() {
        model.imageLiveData.observe(this, Observer {
            /**
             * purpose of adding this condition is if user open first time without turning on internet connection and database have no data . in that case i am showing a text view
             */
            if(it.isNullOrEmpty()){
                binding.recyclerView.visibility = View.GONE
                binding.NoInternet.visibility = View.VISIBLE
            }else{
                binding.recyclerView.visibility = View.VISIBLE
                binding.NoInternet.visibility = View.GONE
                val adapter = ImageAdapter(it)
                binding.recyclerView.adapter = adapter
                binding.recyclerView.layoutManager = LinearLayoutManager(this)
            }

        })
    }

}