package com.hatchworks.newyorktimes.network

import com.hatchworks.newyorktimes.models.ApiResponse
import com.hatchworks.newyorktimes.models.Article
import com.hatchworks.newyorktimes.utils.Const
import com.hatchworks.newyorktimes.utils.GradleInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//This is the interface class fot new york times api
interface NewYorkTimesApiService {

    //you can see all the information in the const class
    @GET(Const.URL_ARCHIVE_API)
    fun getMonthlyArchive(
        @Path(Const.ARCHIVE_PARAM_YEAR) year: Int,
        @Path(Const.ARCHIVE_PARAM_MONTH) month: Int,
        @Query(Const.ARCHIVE_PARAM_API_KEY) apiKey: String
    ): Call<ApiResponse>
}