package com.example.learnviewmodel2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.learnviewmodel2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel : MainActivityViewModel
    private lateinit var viewModelFactory : MainActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = MainActivityViewModelFactory(125)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainActivityViewModel::class.java]

        val etNumberToAdd = binding.etNumberToAdd
        val btnAdd = binding.btnAdd
        val tvNumber = binding.tvNumber

        viewModel.totalData.observe(this, Observer{
            tvNumber.text = it.toString()
        })

        btnAdd.setOnClickListener {
            viewModel.add(etNumberToAdd.text.toString().toInt()).toString()
        }

    }
}