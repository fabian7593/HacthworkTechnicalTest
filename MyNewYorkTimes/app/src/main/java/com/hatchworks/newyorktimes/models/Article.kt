package com.hatchworks.newyorktimes.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

//This is the object structure of all the important information that I need to create my new york times app
//This have another list for keyword and Multimedia as well.
@Parcelize
data class Article(
    val headline_main: String,

    @SerializedName("abstract")
    val abstract: String?,

    @SerializedName("section_name")
    val section_name: String?,

    @SerializedName("pub_date")
    val pub_date: String?,

    @SerializedName("web_url")
    val web_url: String?,

    @SerializedName("multimedia")
    val multimedia: List<Multimedia>?,

    @SerializedName("_id")
    val _id: String?,

    @SerializedName("source")
    val source: String?,

    @SerializedName("print_section")
    val print_section: String?,

    @SerializedName("keywords")
    val keywords: List<Keyword>?,

    @SerializedName("print_page")
    val print_page: String?,

    @SerializedName("byline")
    val by_line_original: String?
) : Parcelable





