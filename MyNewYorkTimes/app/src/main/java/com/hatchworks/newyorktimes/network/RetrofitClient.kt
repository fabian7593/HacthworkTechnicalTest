package com.hatchworks.newyorktimes.network

import com.hatchworks.newyorktimes.utils.GradleInfo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//This object works as a Singleton instance for the retrofit Object
object RetrofitClient {

    //get the base url from gradle properties
    private val BASE_URL = GradleInfo.baseUrl

    //create the builder and necessary settings for use the class
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //create the retrofit object with the respective service
    //this is a public variable, for use as "static"
    val apiService = retrofit.create(NewYorkTimesApiService::class.java)
}

