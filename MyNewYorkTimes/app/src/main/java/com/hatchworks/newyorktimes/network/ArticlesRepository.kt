package com.hatchworks.newyorktimes.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hatchworks.newyorktimes.models.ApiResponse
import com.hatchworks.newyorktimes.models.Article
import com.hatchworks.newyorktimes.utils.GradleInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//For Principle of separate responsabillity, I create a repository
class ArticlesRepository {

    //this is the variable live date to get the list of articles
    private val _articlesLiveData = MutableLiveData<List<Article>>()

    //get the livedata outsite this class
    fun getArticlesLiveData(): LiveData<List<Article>> {
        return _articlesLiveData
    }

    //This method get the articlesand return a list
    fun loadArticles(year: Int, month: Int) {
        //call the url from retrofit
        val call = RetrofitClient.apiService.getMonthlyArchive(year, month, GradleInfo.apiKey)
        call.enqueue(object : Callback<ApiResponse> {

            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val articles = response.body()?.response?.docs
                    _articlesLiveData.value = articles
                } else {
                    _articlesLiveData.value = null
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                _articlesLiveData.value = null
            }
        })
    }

}