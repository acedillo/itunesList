package com.cedillo.technosoft.myapplication.repository

import com.cedillo.technosoft.myapplication.model.ItunesResult

interface Repository {

    suspend fun getList(artist: String): ItunesResult
}