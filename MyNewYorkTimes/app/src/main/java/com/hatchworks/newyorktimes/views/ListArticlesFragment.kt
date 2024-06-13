package com.hatchworks.newyorktimes.views

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hatchworks.newyorktimes.adapters.ArticleListAdapter
import com.hatchworks.newyorktimes.databinding.FragmentListArticlesBinding
import com.hatchworks.newyorktimes.viewModels.MainViewModel
import com.hatchworks.newyorktimes.models.Article

class ListArticlesFragment : Fragment() {

    //THIS is the variable to use the view model
    private lateinit var viewModel: MainViewModel
    //data binding
    private lateinit var binding: FragmentListArticlesBinding
    //List of Articles data
    private lateinit var adapter: ArrayAdapter<Article>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListArticlesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //view model initialization
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setAdapter()
        setEvents()
        setObserver()
        callApi(2024, 4)
    }

    fun setAdapter(){
        //init and set the adapter into listview
        adapter = ArticleListAdapter(requireContext(), ArrayList())
        binding.listView.adapter = adapter
    }

    fun setEvents(){
        // Configure On Item click listener
        binding.listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->

                //select the article
                val article = parent.getItemAtPosition(position) as Article
                viewModel.setSelectedArticle(article)

                //Redirect fragment to detail fragment
                requireActivity().supportFragmentManager.beginTransaction()
                    // .replace(R.id.fragment_container, ArticleDetailFragment())
                    .addToBackStack(null)
                    .commit()
            }
    }

    fun setObserver(){
        //The observer to change the articles, and update the adapter
        viewModel.articlesLiveData.observe(viewLifecycleOwner, Observer { articles ->
            adapter.clear()
            adapter.addAll(articles)
            adapter.notifyDataSetChanged()
        })
    }

    fun callApi(year : Int, month : Int){
        // Call the NYT Api
        viewModel.callNYTApi(year, month)
    }
}