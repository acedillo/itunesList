package com.cedillo.technosoft.myapplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.cedillo.technosoft.myapplication.model.Content

class ItunesAdapter(private val list : List<Content>) : RecyclerView.Adapter<ItunesAdapter.ItunesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItunesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_text, parent, false)
        return ItunesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(viewHolder: ItunesViewHolder, position: Int) {
        val data = list[position].trackName
        viewHolder.text.text = data
    }


    inner class ItunesViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val text = view.findViewById<TextView>(R.id.text_view)
    }
}