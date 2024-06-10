package com.hatchworks.newyorktimes.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    val headline_main: String,
    val abstract: String?,
    val section_name: String?,
    val pub_date: String?,
    val web_url: String?,
    val multimedia: List<Multimedia>?,
    val _id: String?,
    val source: String?,
    val print_section: String?,
    val keywords: List<Keyword>?,
    val print_page: String?,
    val by_line_original: String?
) : Parcelable





