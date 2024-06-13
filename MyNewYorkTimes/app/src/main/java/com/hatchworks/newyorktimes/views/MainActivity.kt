package com.hatchworks.newyorktimes.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hatchworks.newyorktimes.R
import com.hatchworks.newyorktimes.databinding.ActivityMainBinding

//The main activity to start the application
class MainActivity : AppCompatActivity() {

    //This is the data binding of the layout view
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inflate the xml layout here, set it on the screen
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //This is for validate the first activity creation
        if (savedInstanceState == null) {

            //Replace the fragment container with new fragment, in this case the List of articles.
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ListArticlesFragment())
                .commit()
        }
    }
}