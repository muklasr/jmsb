package com.jmsb.segera.ui.pertemuan

import android.database.Cursor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jmsb.segera.R
import com.jmsb.segera.adapter.PertemuanAdapter
import com.jmsb.segera.helper.DataHelper
import com.jmsb.segera.model.Matkul
import com.jmsb.segera.model.Pertemuan
import com.jmsb.segera.ui.matkul.AddMatkulFragment
import kotlinx.android.synthetic.main.fragment_pertemuan.view.*
import kotlin.collections.ArrayList


class PertemuanFragment : Fragment() {

    private lateinit var dashboardViewModel: PertemuanViewModel
    var list: ArrayList<Pertemuan> = ArrayList()
    lateinit var root: View


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(PertemuanViewModel::class.java)
        root = inflater.inflate(R.layout.fragment_pertemuan, container, false)

        root.rootView.btnAdd.setOnClickListener {
            showBottomSheetDialog()
        }

        loadData()

        return root
    }

    fun loadData() {
        val dataHelper = DataHelper(root.context)
        val db = dataHelper.readableDatabase
//
////        val c = Calendar.getInstance()
////        val df = SimpleDateFormat("W")
////        val currentTime = df.format(c.time)
////        val hari = Integer.valueOf(currentTime) - 1
////        val cursor: Cursor = db.rawQuery("SELECT * FROM jadwal WHERE hari=" + hari, null)
        val cursor: Cursor = db.rawQuery("SELECT * FROM pertemuan", null)
        for (i in 0 until cursor.count step 1) {
            cursor.moveToPosition(i)

            var matkul = ""
            val db2 = dataHelper.readableDatabase
            val cursor2: Cursor =
                db2.rawQuery("SELECT matkul FROM matkul WHERE id=" + cursor.getInt(0), null)
            for (i in 0 until cursor.count step 1) {
                cursor2.moveToPosition(i)
                matkul = cursor2.getString(0).toString()
            }

            val jadwal = Pertemuan(
                cursor.getInt(0), //id
                cursor.getInt(1), //matkul
                matkul, //matkul
                cursor.getInt(2), //sks
                cursor.getString(3), //hari
                cursor.getString(4), //jam
                cursor.getString(5) //ruang
            )
            list.add(jadwal)
        }
        db.close()
        root.rootView.rvJadwal.layoutManager = LinearLayoutManager(root.context)
        root.rootView.rvJadwal.adapter = PertemuanAdapter(root.context, list)
    }

    private fun showBottomSheetDialog() {
        val addBottomSheet = AddPertemuanFragment()
        addBottomSheet.show(activity?.supportFragmentManager!!, "TAG")
    }
}