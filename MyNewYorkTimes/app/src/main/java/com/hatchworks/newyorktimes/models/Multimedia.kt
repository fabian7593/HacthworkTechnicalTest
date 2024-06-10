package com.hatchworks.newyorktimes.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Multimedia(
    val url: String?,
    val format: String?,
    val type: String?,
    val sub_type: String?,
    val width: Int?,
    val height: Int?
) : Parcelable