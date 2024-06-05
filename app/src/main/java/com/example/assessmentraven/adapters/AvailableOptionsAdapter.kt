package com.example.assessmentraven.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.assessmentraven.R

class AvailableOptionsAdapter(context: Context): ArrayAdapter<String>(context, android.R.layout.simple_spinner_item) {

    init {
        // Retrieve the options from resources
        val genderOptions = context.resources.getStringArray(R.array.available_options)
        val list = mutableListOf<String>()
        list.add("") // Add empty option at the beginning
        list.addAll(genderOptions.toList())
        addAll(list)
    }

    // Override getView to set text color for spinner item
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent)
        val textView = view.findViewById<TextView>(android.R.id.text1)
        textView.setTextColor(ContextCompat.getColor(context, android.R.color.black))
        return view
    }

    // Override getDropDownView to set text color for dropdown item
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        val textView = view.findViewById<TextView>(android.R.id.text1)
        textView.setTextColor(ContextCompat.getColor(context, android.R.color.black))
        return view
    }
}