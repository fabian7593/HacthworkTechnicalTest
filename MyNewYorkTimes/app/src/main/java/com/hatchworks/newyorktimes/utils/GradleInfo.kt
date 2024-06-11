package com.hatchworks.newyorktimes.utils
import com.hatchworks.newyorktimes.BuildConfig

//This class access to Build Config variables
//If this variables are with important information, these are brought from the gradle.properties
object GradleInfo {
    val baseUrl: String get() = BuildConfig.NYT_BASE_URL
    val apiKey: String get() = BuildConfig.NYT_API_KEY
}