package com.jmsb.segera.ui.absen

import android.database.Cursor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jmsb.segera.R
import com.jmsb.segera.adapter.JadwalAdapter
import com.jmsb.segera.helper.DataHelper
import com.jmsb.segera.model.Jadwal
import kotlinx.android.synthetic.main.fragment_absen.view.*

class AbsenFragment : Fragment() {

    private lateinit var homeViewModel: AbsenViewModel
    val list: ArrayList<Jadwal> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(AbsenViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_absen, container, false)

        val dataHelper = DataHelper(root.context)
        val db = dataHelper.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM jadwal", null)
        cursor.moveToFirst()
        for (i in 0 until cursor.count step 1) {
            cursor.moveToPosition(i)
            val jadwal = Jadwal(
                0,
                cursor.getString(1),
                cursor.getInt(2),
                cursor.getInt(3),
                cursor.getString(4),
                cursor.getInt(5),
                cursor.getInt(6),
                cursor.getString(7),
                cursor.getString(8)
            )
            list.add(jadwal)
        }
        root.rootView.rvJadwal.layoutManager = LinearLayoutManager(root.context)
        root.rootView.rvJadwal.adapter = JadwalAdapter(root.context, list)
        return root
    }
}