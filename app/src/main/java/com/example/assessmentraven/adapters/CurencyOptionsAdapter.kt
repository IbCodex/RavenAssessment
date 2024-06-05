package com.example.assessmentraven.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.assessmentraven.R

class CurencyOptionsAdapter(context: Context): ArrayAdapter<String>(context, android.R.layout.simple_spinner_item) {

    init {
        val genderOptions = context.resources.getStringArray(R.array.currency_options)
        val list = mutableListOf<String>()
        list.add("")
        list.addAll(genderOptions.toList())
        addAll(list)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
      val view = super.getView(position, convertView, parent)
        view.findViewById<TextView>(android.R.id.text1)?.setTextColor(ContextCompat.getColor(context,android.R.color.black))
       return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        view.findViewById<TextView>(android.R.id.text1)?.setTextColor(ContextCompat.getColor(context,android.R.color.black))
        return view
    }
}