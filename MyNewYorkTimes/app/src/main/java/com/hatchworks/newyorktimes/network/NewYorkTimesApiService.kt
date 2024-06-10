package com.hatchworks.newyorktimes.network

import com.hatchworks.newyorktimes.models.Article
import retrofit2.Call

//This is the interface class fot new york times api
interface NewYorkTimesApiService {

    fun getArticles(): Call<List<Article>>
}