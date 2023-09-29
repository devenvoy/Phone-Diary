package com.example.demoofflinedatabase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDatabsehelper(context: Context?,) : SQLiteOpenHelper(context, "mydayabse.db", null, 1)
{
    override fun onCreate(db: SQLiteDatabase?) {

        var crette =
            "create Table MYDATA(ID integer primary key Autoincrement,NAME text,PHONE text ,EMAIL text, PASSWORD text)"

        db!!.execSQL(crette);
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertdata(fullname: String, email: String, phono: String, pass: String) {
        var dd = "insert into MYDATA (NAME , PHONE , EMAIL , PASSWORD) Values('$fullname','$phono','$email','$pass')"
        writableDatabase.execSQL(dd)
    }

}
