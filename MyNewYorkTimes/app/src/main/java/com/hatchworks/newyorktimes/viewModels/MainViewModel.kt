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

    private val _articlesLiveData = MutableLiveData<List<Article>>()
    val articlesLiveData: LiveData<List<Article>>
        get() = _articlesLiveData

    fun callNYTApi(year : Int, month : Int) {
        val call = RetrofitClient.apiService.getMonthlyArchive(year, month, GradleInfo.apiKey)

        // Ejecutar la llamada asíncrona
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val articles = response.body()
                   // _articlesLiveData.postValue(articles)
                } else {
                  //  _articlesLiveData.postValue(null)
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                _articlesLiveData.postValue(null)
            }
        })
    }
}