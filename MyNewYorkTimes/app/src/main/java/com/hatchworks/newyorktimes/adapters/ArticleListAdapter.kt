package com.hatchworks.newyorktimes.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.hatchworks.newyorktimes.R
import com.hatchworks.newyorktimes.databinding.ListItemArticleBinding
import com.hatchworks.newyorktimes.models.Article
import com.hatchworks.newyorktimes.models.Multimedia
import com.hatchworks.newyorktimes.utils.Const
import com.hatchworks.newyorktimes.utils.GeneralUtils
import com.hatchworks.newyorktimes.utils.GradleInfo
import com.squareup.picasso.Picasso

//Personalize adapter for items list class
class ArticleListAdapter(context: Context, articles: List<Article>) :
    ArrayAdapter<Article>(context, 0, articles) {

        //personalize the view item by item
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var binding: ListItemArticleBinding? = null

        var view = convertView

            //if the current view is null
            //This if is for "Recycler the view", and not create one by one.
        if (view == null) {
            //inflate the view and ser the bindings
            val inflater = LayoutInflater.from(context)
            binding = DataBindingUtil.inflate(inflater, com.hatchworks.newyorktimes.R.layout.list_item_article, parent, false)
            view = binding.root
            view.tag = binding

        } else {
            //if the view is not null, set the binding
            binding = view.tag as ListItemArticleBinding
        }

           //binding the article by item position.
        val article = getItem(position)
            //set the specific data article
        binding?.article = article

        article?.multimedia?.let { multimediaList ->
            val thumbnailUrl =
                GeneralUtils.getUrlMultimedia(multimediaList, Const.IMG_SUBTYPE_THUMB)
            // Set image view with picasso
            GeneralUtils.setPicassoToImageView(thumbnailUrl, binding?.articleImage)
        }

        //ensure the execution of pending bindings
        binding?.executePendingBindings()

        return view!!
    }

}