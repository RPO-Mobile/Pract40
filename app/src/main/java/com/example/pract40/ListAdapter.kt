package com.example.pract40

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.pract40.databinding.ListElementBinding

class ListAdapter : BaseAdapter() {
    private val list = mutableListOf<Message>()

    override fun getCount() : Int = list.count()

    override fun getItem(p0: Int): Any = list[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getView(pos: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(parent?.context)
        val listElement = ListElementBinding.inflate(inflater)
        listElement.tvId.text = list[pos].id.toString()
        listElement.tvTime.text = list[pos].time.toString()
        return listElement.root
    }

    fun add(newMessage : Message){
        list.add(newMessage)
    }
}