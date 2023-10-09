package com.example.demoofflinedatabase

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.demoofflinedatabase.SlashScreen.Companion.sp
import com.google.android.material.textfield.TextInputEditText


class HomePage : AppCompatActivity() {

    lateinit var listView: ListView
    var reclist = ArrayList<MydataClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        listView = findViewById(R.id.listview)
        var myrecdb = MyDatabsehelper(this@HomePage)
        var data = myrecdb.getrecords(sp.getInt("uid", 1))

        while (data.moveToNext()) {
            val name = data.getString(2)
            val num = data.getInt(3)
            reclist.add(MydataClass(name, num.toString()))
        }
        val adpater = MyrecAdapter(this@HomePage, reclist)
        listView.adapter = adpater
    }

    fun close(view: View) {
        finish()
    }

    fun addrecord(view: View) {

        var dialog = Dialog(this@HomePage)
        dialog.setContentView(R.layout.dialog_layout)
        dialog.getWindow()!!
            .setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.setCancelable(false)
        dialog.window!!.getAttributes().windowAnimations = R.style.animation

        var number: TextInputEditText
        var name: TextInputEditText
        var save: AppCompatButton


        number = dialog.findViewById(R.id.number)
        name = dialog.findViewById(R.id.name)
        save = dialog.findViewById(R.id.save)

        save.setOnClickListener(View.OnClickListener {
            dialog.dismiss()

            var mm = MyDatabsehelper(this@HomePage)

            mm.insertCR(number.text.toString(), name.text.toString(), 1);

            Toast.makeText(this@HomePage, "okay clicked", Toast.LENGTH_SHORT).show()

            startActivity(Intent(this@HomePage, HomePage::class.java))
        })
        dialog.show()


    }
}
