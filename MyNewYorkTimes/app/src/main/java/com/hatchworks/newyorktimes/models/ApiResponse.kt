package com.hatchworks.newyorktimes.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//this is the data structure of the api response
@Parcelize
data class ApiResponse(
    val status: String,
    val response: DocsResponse
) : Parcelable