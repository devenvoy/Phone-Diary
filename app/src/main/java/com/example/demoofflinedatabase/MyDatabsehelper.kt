package com.example.demoofflinedatabase

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDatabsehelper(var context: Context?) : SQLiteOpenHelper(context, "mydayabse.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {

        var crette =
            "create Table MYDATA(ID integer primary key Autoincrement,NAME text,PHONE text ,EMAIL text, PASSWORD text)"

        db!!.execSQL(crette);
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertdata(fullname: String, email: String, phono: String, pass: String) {
        var dd =
            "insert into MYDATA (NAME , PHONE , EMAIL , PASSWORD) Values('$fullname','$phono','$email','$pass')"
        writableDatabase.execSQL(dd)
    }

    fun loginuser(email: String, pass: String) : Cursor {

        var vv = "select * from MYDATA where EMAIL = '$email' and PASSWORD = '$pass'"

        var cur: Cursor = readableDatabase.rawQuery(vv, null)
        return cur

//        wherehile (cur.moveToNext()) {
//
//            var id = cur.getInt(0)
//            var name = cur.getString(1)
//            var email = cur.getString(3)
//            var pass = cur.getString(4)
//
//            if (toString.equals(email) && toString1.equals(pass)) {
//
//                Toast.makeText(context, "LOGINNNN", Toast.LENGTH_SHORT).show()
//            }
//        }

    }

    fun checkUser(email: String): Cursor {
        var checkqry = "select * from MYDATA where EMAIL = '$email'"

        val cur = readableDatabase.rawQuery(checkqry,null)

        return cur

    }


}