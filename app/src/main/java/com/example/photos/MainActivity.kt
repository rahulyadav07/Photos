package com.example.photos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
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
            it?.let {
                val adapter = ImageAdapter(it)
                binding.recyclerView.adapter = adapter
                binding.recyclerView.layoutManager = LinearLayoutManager(this)
            }
        })
    }
}