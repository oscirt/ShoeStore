package com.example.shoestore

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.get
import androidx.databinding.BindingAdapter
import com.example.shoestore.models.Shoe

@BindingAdapter("listOfShoes")
fun submitList(linearLayout: LinearLayout, list: List<Shoe>?) {
    for (i in 0 until list!!.size) {
        View.inflate(linearLayout.context, R.layout.shoe_item_view, linearLayout)
        val createdView = linearLayout[i]
        val shoe = list[i]
        createdView.findViewById<TextView>(R.id.nameTextView).text = shoe.name
        createdView.findViewById<TextView>(R.id.sizeTextView).text = shoe.size.toString()
        createdView.findViewById<TextView>(R.id.descriptionTextView).text = shoe.description
        createdView.findViewById<TextView>(R.id.producerTextView).text = shoe.company
    }
}