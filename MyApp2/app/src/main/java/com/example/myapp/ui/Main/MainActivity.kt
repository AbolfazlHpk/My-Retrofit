package com.example.myapp.ui.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp.data.Repository.PostRepository
import com.example.myapp.databinding.ActivityMainBinding
import com.example.myapp.ui.adapter.ItemCardAdapter
import com.example.retrofit.ui.viewmodel.PostViewModel
import com.example.retrofit.ui.viewmodel.factory.PostViewModelFactory


class MainActivity : AppCompatActivity() {
     private lateinit var viewModel:PostViewModel
     private val postAdapter by lazy { ItemCardAdapter() }
     private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindViews()
    }

    private fun bindViews() {
        val repository = PostRepository()
        val viewModelFactory = PostViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[PostViewModel::class.java]
        viewModel.getCustomPosts(1,"id","asc")
        viewModel.customPostResponse.observe(this){Response->

            if (Response.isSuccessful)
                Response.body()?.let { postAdapter.setData(it) }
            else Toast.makeText(this, Response.code(), Toast.LENGTH_SHORT).show()
        }
        binding.recyclerView.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = postAdapter
        }
    }
}

