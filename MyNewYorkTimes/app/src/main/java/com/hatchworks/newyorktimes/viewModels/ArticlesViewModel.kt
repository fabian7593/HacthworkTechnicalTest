package com.hatchworks.newyorktimes.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hatchworks.newyorktimes.models.ApiResponse
import com.hatchworks.newyorktimes.models.Article
import com.hatchworks.newyorktimes.network.ArticlesRepository
import com.hatchworks.newyorktimes.network.RetrofitClient
import com.hatchworks.newyorktimes.utils.GradleInfo
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//This class have all the logic to refresh the view and to connect with the data.
class ArticlesViewModel : ViewModel() {

    //Create an instance of repository
    private val repository = ArticlesRepository()

    //set the variable livedata, with the livedata of the respective repository
    val articlesLiveData: LiveData<List<Article>> = repository.getArticlesLiveData()


    //the variable of selected live data or selected item
    private val _articleSelectedLiveData = MutableLiveData<Article>()
    val articleSelectedLiveData: LiveData<Article>
        get() = _articleSelectedLiveData


    fun setSelectedArticle(article: Article) {
        _articleSelectedLiveData.value = article
    }

    //call the load data from repo
    fun callNYTApi(year: Int, month: Int) {
        // Call the repository to get the articles
        repository.loadArticles(year, month)
    }
}