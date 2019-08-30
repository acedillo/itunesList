package com.cedillo.technosoft.myapplication.network

import com.cedillo.technosoft.myapplication.model.ItunesResult
import retrofit2.http.GET
import retrofit2.http.Query

interface ItunesEndPoint {

    @GET("search?")
    suspend fun getList(@Query("term") artist : String) : ItunesResult
}