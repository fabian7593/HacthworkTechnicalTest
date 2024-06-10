package com.hatchworks.newyorktimes.views
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.hatchworks.newyorktimes.R
import com.hatchworks.newyorktimes.viewModels.MainViewModel
import com.hatchworks.newyorktimes.databinding.ActivityMainBinding
import androidx.lifecycle.ViewModelProvider
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

        // Specify the lifecycle owner to observe LiveData
        binding.lifecycleOwner = this

    }
}