package com.hatchworks.newyorktimes.views
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hatchworks.newyorktimes.R
import com.hatchworks.newyorktimes.viewModels.MainViewModel
import com.hatchworks.newyorktimes.databinding.ActivityMainBinding
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    //this is the variable for view binding
    private lateinit var binding: ActivityMainBinding

    //this is the view model variable instance by viewModels
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using Data Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Bind the ViewModel to the layout
        binding.viewModel = viewModel

        //call the view model with specific params
        viewModel.callNYTApi(2024, 6)

        // This is the livedata to wait the change into viewModel
        binding.lifecycleOwner = this

    }
}