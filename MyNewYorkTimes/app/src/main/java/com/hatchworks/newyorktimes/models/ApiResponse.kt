package com.hatchworks.newyorktimes.models

//this is the data structure of the api response
data class ApiResponse(
    val status: String,
    val response: DocsResponse
)