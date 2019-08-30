package com.cedillo.technosoft.myapplication

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.cedillo.technosoft.myapplication.repository.RetrofitRepository
import com.cedillo.technosoft.myapplication.viewModel.ItunesViewModel

class MainActivity : AppCompatActivity() {

    var recyclerView : RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return ItunesViewModel(RetrofitRepository()) as T
            }

        }).get(ItunesViewModel::class.java)

        initialize()
        viewModel.loadList("Beyonce")

        viewModel.searchResult.observe(this, Observer {
            if(it != null){
                recyclerView?.adapter = ItunesAdapter(it.asList())
            }
        })

    }

    fun initialize(){
        recyclerView = findViewById<RecyclerView>(R.id.list)
        recyclerView?.layoutManager = LinearLayoutManager(this)
    }
}
