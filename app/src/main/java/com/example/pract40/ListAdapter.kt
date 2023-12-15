package com.example.pract40

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.pract40.databinding.ListElementBinding
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.Date
import java.util.Locale

class ListAdapter(private val list: MutableList<Message>) : BaseAdapter() {
    override fun getCount() : Int = list.count()

    override fun getItem(p0: Int): Any = list[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getView(pos: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(parent?.context)
        val listElement = ListElementBinding.inflate(inflater)

        val date = Date(list[pos].time)

        val sdf = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
        val formattedDate = sdf.format(date)

        listElement.tvId.text = list[pos].id.toString()
        listElement.tvTime.text = formattedDate
        return listElement.root
    }
}