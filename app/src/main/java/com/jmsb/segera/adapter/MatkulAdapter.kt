package com.jmsb.segera.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jmsb.segera.R
import com.jmsb.segera.model.Matkul
import kotlinx.android.synthetic.main.item_row.view.*

class MatkulAdapter(val context: Context, val items: ArrayList<Matkul>) :
    RecyclerView.Adapter<MatkulAdapter.ListViewVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewVH {
        val view = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false)
        return ListViewVH(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ListViewVH, position: Int) {

        val matkul = items.get(position)

        holder.itemView.tvMatkul.text = matkul.nama+"("+matkul.sks+")"
        holder.itemView.tvJam.text = matkul.dosen
        holder.itemView.tvRuang.text = matkul.bolos.toString()+"/"+matkul.jatah.toString()
    }

    class ListViewVH(view: View) : RecyclerView.ViewHolder(view)
}