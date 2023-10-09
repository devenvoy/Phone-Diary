package com.example.demoofflinedatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyrecAdapter(var homePage: HomePage, var reclist: ArrayList<MydataClass>): BaseAdapter() {
    override fun getCount(): Int  = reclist.size

    override fun getItem(position: Int): Any  = position

    override fun getItemId(position: Int): Long  = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var Rname : TextView
        var Rnum : TextView

       val view = LayoutInflater.from(homePage).inflate(R.layout.myrec,parent,false)

        Rnum = view.findViewById(R.id.Rnum);
        Rname = view.findViewById(R.id.Rname);

        Rnum.setText(reclist.get(position).phone)
        Rname.setText(reclist.get(position).name)
        return  view;
    }

}
