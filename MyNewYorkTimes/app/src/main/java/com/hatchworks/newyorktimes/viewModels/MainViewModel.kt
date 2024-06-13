package com.hatchworks.newyorktimes.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hatchworks.newyorktimes.models.ApiResponse
import com.hatchworks.newyorktimes.models.Article
import com.hatchworks.newyorktimes.network.RetrofitClient
import com.hatchworks.newyorktimes.utils.GradleInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//This class have all the logic to refresh the view and to connect with the data.
class MainViewModel : ViewModel() {

    //This variable is the information object adapt from the json and the call to the API
    private val _articlesLiveData = MutableLiveData<List<Article>>()
    val articlesLiveData: LiveData<List<Article>>
        get() = _articlesLiveData


    private val _articleSelectedLiveData = MutableLiveData<Article>()
    val articleSelectedLiveData: LiveData<Article>
        get() = _articleSelectedLiveData

    fun setSelectedArticle(article: Article) {
        _articleSelectedLiveData.value = article
    }


    //This is the method to call the main request
    fun callNYTApi(year : Int, month : Int) {

        //this ids the instance of call retrofit, and method interface
        val call = RetrofitClient.apiService.getMonthlyArchive(year, month, GradleInfo.apiKey)

        // This is the asyncronous callback from service New York Time
        call.enqueue(object : Callback<ApiResponse> {

            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {

                //if the response have data
                if (response.isSuccessful) {
                    val articles = response.body()?.response?.docs
                    _articlesLiveData.value = articles
                } else {
                    _articlesLiveData.value = null
                }
            }

            //If callback have an error
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                _articlesLiveData.value = null
            }
        })
    }
}