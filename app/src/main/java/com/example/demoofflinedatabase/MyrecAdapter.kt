package com.example.demoofflinedatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyrecAdapter(private var homePage: HomePage, private var reclist: ArrayList<MydataClass>) : BaseAdapter() {
    override fun getCount(): Int = reclist.size

    override fun getItem(position: Int): Any = position

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var Rname: TextView
        var Rnum: TextView

        val view = LayoutInflater.from(homePage).inflate(R.layout.myrec, parent, false)

        Rname = view.findViewById(R.id.Rname)
        Rnum = view.findViewById(R.id.Rnum)

        Rname.text = reclist[position].name
        Rnum.text = reclist[position].phone
        return view;
    }

}
