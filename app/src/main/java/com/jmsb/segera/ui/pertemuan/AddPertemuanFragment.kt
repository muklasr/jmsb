package com.jmsb.segera.ui.pertemuan

import android.database.Cursor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.jmsb.segera.R
import com.jmsb.segera.helper.DataHelper
import kotlinx.android.synthetic.main.add_pertemuan_fragment.*
import kotlinx.android.synthetic.main.add_pertemuan_fragment.view.*

class AddPertemuanFragment : BottomSheetDialogFragment() {

    lateinit var root: View
    lateinit var spinnerMatkul: Spinner

    val list_id: ArrayList<Int> = ArrayList()
    val list_name: ArrayList<String> = ArrayList()
//    var days = arrayOf("Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu")

    private var fragmentView: View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.add_pertemuan_fragment, container, false)
        spinnerMatkul = root.findViewById(R.id.etIdMatkul);

        loadMatkul()

        root.btnSave.setOnClickListener {
            save()
        }

        return root

    }

    private fun save() {
        val dbHelper = DataHelper(root.context)
        val matkul = list_id.get(spinnerMatkul.selectedItemPosition)
        val hari = etHari.selectedItemPosition
        val jam_mulai = etJamMulai.selectedItem.toString()
        val jam_selesai = etJamSelesai.selectedItem.toString()
        val ruang = etRuang.text.toString()

        dbHelper.insert_pertemuan(
            dbHelper.writableDatabase,
            matkul,
            hari,
            jam_mulai,
            jam_selesai,
            ruang
        )

        Toast.makeText(activity, "Berhasil", Toast.LENGTH_SHORT).show()
//        (fragmentView as MatkulFragment).loadData()

        dialog!!.dismiss()
    }

    private fun loadMatkul() {
        val dataHelper = DataHelper(root.context)
        val db = dataHelper.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM matkul", null)
        cursor.moveToFirst()
        for (i in 0 until cursor.count step 1) {
            cursor.moveToPosition(i)
            list_id.add(cursor.getInt(0))
            list_name.add(cursor.getString(1).toString())
        }
        val adapter =
            ArrayAdapter(root.context, android.R.layout.simple_spinner_dropdown_item, list_name)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerMatkul.adapter = adapter

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}