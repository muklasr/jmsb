package com.jmsb.segera.ui.matkul

import android.database.Cursor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jmsb.segera.R
import com.jmsb.segera.adapter.MatkulAdapter
import com.jmsb.segera.helper.DataHelper
import com.jmsb.segera.model.Matkul
import kotlinx.android.synthetic.main.fragment_matkul.view.*

class MatkulFragment : Fragment() {

    private lateinit var homeViewModel: MatkulViewModel
    val list: ArrayList<Matkul> = ArrayList()
    lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(MatkulViewModel::class.java)
        root = inflater.inflate(R.layout.fragment_matkul, container, false)

        loadData()

        root.rootView.btnAdd.setOnClickListener {
            showBottomSheetDialog()
        }

        return root
    }

    fun loadData() {

        val dataHelper = DataHelper(root.context)
        val db = dataHelper.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM matkul", null)
        cursor.moveToFirst()
        for (i in 0 until cursor.count step 1) {
            cursor.moveToPosition(i)
            val matkul = Matkul(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getInt(2),
                cursor.getInt(3),
                cursor.getInt(4),
                cursor.getString(5)
            )
            list.add(matkul)
        }
        root.rootView.rvMatkul.layoutManager = LinearLayoutManager(root.context)
        root.rootView.rvMatkul.adapter = MatkulAdapter(root.context, list)
    }

    private fun showBottomSheetDialog() {
        val addBottomSheet = AddMatkulFragment()
        addBottomSheet.show(activity?.supportFragmentManager!!,"TAG")
    }
}