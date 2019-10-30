package com.jmsb.segera.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jmsb.segera.R
import com.jmsb.segera.model.Jadwal
import kotlinx.android.synthetic.main.item_row.view.*

class JadwalAdapter(val context: Context, val items: ArrayList<Jadwal>) :
    RecyclerView.Adapter<JadwalAdapter.ListViewVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewVH {
        val view = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false)
        return ListViewVH(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ListViewVH, position: Int) {

        val jadwal = items.get(position)

        holder.itemView.tvMatkul.text = jadwal.nama
        holder.itemView.tvJam.text = jadwal.jam
        holder.itemView.tvRuang.text = jadwal.ruangan
    }

    class ListViewVH(view: View) : RecyclerView.ViewHolder(view)
}