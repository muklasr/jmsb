package com.jmsb.segera.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.jmsb.segera.R
import kotlinx.android.synthetic.main.add_bottom_sheet.*

class AddFragment() : BottomSheetDialogFragment() {

    var days = arrayOf("Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu")

    private var fragmentView: View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.add_bottom_sheet, container, false)

        spHari?.adapter = ArrayAdapter(root.context, android.R.layout.simple_spinner_dropdown_item, days)

        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}