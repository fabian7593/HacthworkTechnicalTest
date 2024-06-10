package com.hatchworks.newyorktimes.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Keyword(
    val value: String?,
    val rank: Int?
) : Parcelable
