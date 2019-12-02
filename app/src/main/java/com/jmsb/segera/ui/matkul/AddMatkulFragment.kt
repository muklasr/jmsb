package com.jmsb.segera.ui.matkul

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.jmsb.segera.R
import com.jmsb.segera.helper.DataHelper
import android.widget.Toast
import kotlinx.android.synthetic.main.add_matkul_fragment.*
import kotlinx.android.synthetic.main.add_matkul_fragment.view.*


class AddMatkulFragment : BottomSheetDialogFragment() {

    lateinit var root: View

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
        root = inflater.inflate(R.layout.add_matkul_fragment, container, false)

//        spHari?.adapter =
//            ArrayAdapter(root.context, android.R.layout.simple_spinner_dropdown_item, days)

        root.btnSave.setOnClickListener {
            save()
        }

        return root

    }

    private fun save() {
        val dbHelper = DataHelper(root.context)
        val matkul = etMatkul.text.toString()
        val sks = etSks.text.toString().toInt()
        val jatah = etJatah.text.toString().toInt()
        val dosen = etDosen.text.toString()

        dbHelper.insert_matkul(dbHelper.writableDatabase, matkul, sks, jatah, 0, dosen)

        Toast.makeText(activity, "Berhasil", Toast.LENGTH_SHORT).show()
//        (fragmentView as MatkulFragment).loadData()

        dialog!!.dismiss()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}