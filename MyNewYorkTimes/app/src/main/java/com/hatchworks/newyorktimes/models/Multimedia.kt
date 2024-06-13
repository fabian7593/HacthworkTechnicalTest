package com.hatchworks.newyorktimes.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

//This have all the important information of multimedia files
@Parcelize
data class Multimedia(
    @SerializedName("url")
    val url: String?,

    @SerializedName("type")
    val type: String?,

    @SerializedName("subtype")
    val subtype: String?,

    @SerializedName("width")
    val width: Double?,

    @SerializedName("height")
    val height: Double?
) : Parcelable

