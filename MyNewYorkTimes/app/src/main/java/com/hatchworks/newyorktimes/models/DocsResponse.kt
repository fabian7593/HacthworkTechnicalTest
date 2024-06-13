package com.hatchworks.newyorktimes.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//The docs is the list of articles
@Parcelize
data class DocsResponse(
    val docs: List<Article>
) : Parcelable