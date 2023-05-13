package com.example.clean_architecture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.clean_architecture.R
import com.example.clean_architecture.databinding.ActivityMainBinding
import com.example.clean_architecture.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val viewModel = ViewModelProvider(this, MainViewModel.MainViewModelFactory() )[MainViewModel::class.java]
        val postStr = binding.tvPost
        Log.d("MainActivity", "click" + " "+ postStr)
        Log.d("MainActivity", "click" + " "+ binding.btnFetchPost)
//        binding.btnFetchPost.setOnClickListener {
//            Log.d("MainActivity", "Button click")
//        }
        binding.btnFetchPost.setOnClickListener {
            Log.d("MainActivity", "Button click")
            viewModel.getPost(1)
            viewModel.post.observe(this) {
                binding.tvPost.text = "${it.id} ${it.title} ${it.body}}"
            }
        }
    }
}