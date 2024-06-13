package com.hatchworks.newyorktimes.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hatchworks.newyorktimes.adapters.ArticleResponseAdapter
import com.hatchworks.newyorktimes.models.Article
import com.hatchworks.newyorktimes.utils.GradleInfo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//This object works as a Singleton instance for the retrofit Object
object RetrofitClient {

    //get the base url from gradle properties
    private val BASE_URL = GradleInfo.baseUrl

    //set the adapter of any individual articles.
    //All the articles on the response convert into my own Article Data structure.
    private val gson: Gson = GsonBuilder()
        .registerTypeAdapter(Article::class.java, ArticleResponseAdapter())
        .create()

    //create the builder and necessary settings for use the class
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    //create the retrofit object with the respective service
    //this is a public variable, to use outside this class, similar like "static"
    val apiService = retrofit.create(NewYorkTimesApiService::class.java)
}

