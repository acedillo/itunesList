package com.cedillo.technosoft.myapplication.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.cedillo.technosoft.myapplication.model.Content
import com.cedillo.technosoft.myapplication.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ItunesViewModel(val repository : Repository) : ViewModel() {

    private val _searchResult = MutableLiveData<Array<Content>>()

    private val coroutineScope = GlobalScope

    val searchResult : LiveData<Array<Content>>
    get() = _searchResult

    fun loadList(artist : String){
       coroutineScope.launch(Dispatchers.IO){
           getList(artist)
       }

    }

    private suspend fun getList(artist : String) {
        val contents = repository.getList(artist)
        Log.d("ViewModel", contents.toString())
        _searchResult.postValue(contents.results)
    }
}