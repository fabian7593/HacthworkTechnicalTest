package com.hatchworks.newyorktimes.network

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.hatchworks.newyorktimes.models.Article
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

//This annotation simulate really android environment
//@RunWith(RobolectricTestRunner::class)
//annotation, not use manifest and any data from this file
//@Config(manifest = Config.NONE)
class ArticlesRepositoryTest{

    //This rule is for execute all the task inmediatly
    //with this rule we can use LiveData in test environment
    //this comes from androidx.arch.core:core-testing:2.1.0
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    @Test
    fun `Invalid Year and month`(){
        val repository = ArticlesRepository()
        repository.loadArticles(90000, 45)
        val articlesLiveData: LiveData<List<Article>> = repository.getArticlesLiveData()

        // Observe without fragment or activity the LiveData
        articlesLiveData.observeForever(object : Observer<List<Article?>?> {
            override fun onChanged(articles: List<Article?>?) {
                // Check if articles is null since the request should fail
                //assertNull(articles)
                //validate if not have data
                assertFalse(articles!!.isNotEmpty())
                //remove observer to liberate memory
                articlesLiveData.removeObserver(this)
            }
        })
    }


    @Test
    fun `Valid Year and month`(){
        val repository = ArticlesRepository()
        repository.loadArticles(2024, 3)
        val articlesLiveData: LiveData<List<Article>> = repository.getArticlesLiveData()

        // Observe without fragment or activity the LiveData
        articlesLiveData.observeForever(object : Observer<List<Article?>?> {
            override fun onChanged(articles: List<Article?>?) {
                // Check if articles is null since the request should fail
                assertNotNull(articles)
                //valid if have data
                assertTrue(articles!!.isNotEmpty())
                //remove observer to liberate memory
                articlesLiveData.removeObserver(this)
            }
        })
    }
}