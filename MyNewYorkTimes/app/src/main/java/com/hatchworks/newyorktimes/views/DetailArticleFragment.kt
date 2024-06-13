package com.hatchworks.newyorktimes.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hatchworks.newyorktimes.R
import com.hatchworks.newyorktimes.databinding.FragmentDetailArticleBinding
import com.hatchworks.newyorktimes.utils.GeneralUtils
import com.hatchworks.newyorktimes.viewModels.ArticlesViewModel
import com.squareup.picasso.Picasso

class DetailArticleFragment : Fragment(){

        private lateinit var binding: FragmentDetailArticleBinding
        private lateinit var viewModel: ArticlesViewModel

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            binding = FragmentDetailArticleBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            //connect the view model with data binding
            viewModel = ViewModelProvider(requireActivity()).get(ArticlesViewModel::class.java)
            binding.articleDetail = viewModel
            binding.lifecycleOwner = viewLifecycleOwner

            // Observe the LiveData to load the image with Picasso
            viewModel.articleSelectedLiveData.observe(viewLifecycleOwner, Observer { selectedItem ->
                selectedItem?.multimedia?.firstOrNull()?.url?.let { imageUrl ->
                    GeneralUtils.setPicassoToImageView(imageUrl, binding.articleDetailImage)
                }
            })
        }
    }