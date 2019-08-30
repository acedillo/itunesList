package com.cedillo.technosoft.myapplication.repository

import com.cedillo.technosoft.myapplication.model.ItunesResult
import com.cedillo.technosoft.myapplication.network.ItunesEndPoint
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitRepository : Repository {

    companion object {
        private const val BASE_URL = "https://itunes.apple.com/"
    }

    var retrofit: Retrofit
    init {
        val gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create()

         retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
             .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    override suspend fun getList(artist: String): ItunesResult {
        val endPoint = retrofit.create(ItunesEndPoint::class.java)
        return endPoint.getList(artist)
    }

}