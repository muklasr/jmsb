package com.jmsb.segera.ui.jadwal

import android.content.Context
import android.database.Cursor
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.IntegerRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.jmsb.segera.R
import com.jmsb.segera.adapter.JadwalAdapter
import com.jmsb.segera.helper.DataHelper
import com.jmsb.segera.model.Jadwal
import kotlinx.android.synthetic.main.add_bottom_sheet.*
import kotlinx.android.synthetic.main.add_bottom_sheet.view.*
import kotlinx.android.synthetic.main.fragment_absen.view.*
import kotlinx.android.synthetic.main.fragment_absen.view.rvJadwal
import kotlinx.android.synthetic.main.fragment_jadwal.view.*
import java.util.*
import kotlin.collections.ArrayList
import java.text.SimpleDateFormat


class JadwalFragment : Fragment() {

    private lateinit var dashboardViewModel: JadwalViewModel
    var list: ArrayList<Jadwal> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(JadwalViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_jadwal, container, false)

        root.rootView.btnAdd.setOnClickListener {
            showBottomSheetDialog(root.context)
        }

        showRecycler(root)

        return root
    }

    private fun showRecycler(root: View) {
        val dataHelper = DataHelper(root.context)
        val db = dataHelper.readableDatabase

        val c = Calendar.getInstance()
        val df = SimpleDateFormat("W")
        val currentTime = df.format(c.time)
        val hari = Integer.valueOf(currentTime) - 1
        val cursor: Cursor = db.rawQuery("SELECT * FROM jadwal WHERE hari=" + hari, null)
        cursor.moveToFirst()
        for (i in 0 until cursor.count step 1) {
            cursor.moveToPosition(i)
            val jadwal = Jadwal(
                cursor.getInt(0),
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
        db.close()
        root.rootView.rvJadwal.layoutManager = LinearLayoutManager(root.context)
        root.rootView.rvJadwal.adapter = JadwalAdapter(root.context, list)
    }

    private fun showBottomSheetDialog(context: Context) {
        val view = layoutInflater.inflate(R.layout.add_bottom_sheet, null)
        val dialog = BottomSheetDialog(context)
        dialog.setContentView(view)
        dialog.show()
    }
}