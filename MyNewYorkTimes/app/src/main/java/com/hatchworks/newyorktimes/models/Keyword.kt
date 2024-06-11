package com.hatchworks.newyorktimes.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//I just need the value and the rank, this is the keywords in the respective new
//But in thi example I wanna use it as hashtag or something similar
@Parcelize
data class Keyword(
    val value: String?,
    val rank: Int?
) : Parcelable
