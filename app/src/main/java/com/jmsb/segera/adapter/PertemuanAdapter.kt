package com.jmsb.segera.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jmsb.segera.R
import com.jmsb.segera.model.Pertemuan
import kotlinx.android.synthetic.main.item_row.view.*

class PertemuanAdapter(val context: Context, val items: ArrayList<Pertemuan>) :
    RecyclerView.Adapter<PertemuanAdapter.ListViewVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewVH {
        val view = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false)
        return ListViewVH(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ListViewVH, position: Int) {

        val pertemuan = items.get(position)

        holder.itemView.tvMatkul.text = pertemuan.nama.toString()
        holder.itemView.tvJam.text = pertemuan.jam_mulai.toString()+"-"+pertemuan.jam_selesai.toString()
        holder.itemView.tvRuang.text = pertemuan.ruang.toString()
    }

    class ListViewVH(view: View) : RecyclerView.ViewHolder(view)
}