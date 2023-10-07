package com.nester.wollet

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CategoryItemAdapter(private val categories: ArrayList<CategoryItem>, var context: Context) : BaseAdapter() {

    override fun getCount(): Int {
        return categories.size
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View = View.inflate(context, R.layout.category_item, null)

        var icons: ImageView = view.findViewById(R.id.category_image)
        var category: TextView = view.findViewById(R.id.category_title)

        val cat: CategoryItem = categories[position]

        icons.setImageResource(cat.icon)
        category.text = cat.category

        return view
    }


}