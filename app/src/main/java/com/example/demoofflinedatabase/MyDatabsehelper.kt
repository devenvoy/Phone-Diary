package com.example.demoofflinedatabase

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDatabsehelper(var context: Context?) : SQLiteOpenHelper(context, "mydayabsee.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {

        db!!.execSQL("create Table MYDATA(ID integer primary key Autoincrement,NAME text,PHONE text ,EMAIL text, PASSWORD text)")

        db.execSQL("Create table records(cid integer primary key Autoincrement ,uid integer, cname text , cnumber text)")

        db.execSQL("CREATE TABLE TEST(ID INTEGER PRIMARY KEY  AUTOINCREMENT , NAME TEXT )")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun loginuser(email: String, pass: String): Cursor {

        var vv = "select * from MYDATA where EMAIL = '$email' and PASSWORD = '$pass'"

        return readableDatabase.rawQuery(vv, null)
    }

    fun checkUser(email: String): Cursor {
        var checkqry = "select * from MYDATA where EMAIL = '$email'"

        return readableDatabase.rawQuery(checkqry, null)

    }

    fun getrecords(uid: Int): Cursor {
        var sqry = "select * from records where uid = $uid"

        return readableDatabase.rawQuery(sqry, null)
    }

    fun TestLog() {
        var logqry = "INSERT INTO TEST(NAME) VALUES(datetime('now'))"

        writableDatabase.execSQL(logqry)
    }

    fun insertCR(name: String, number: String, uid: Int) {
        var insQ = "insert into records(uid ,cname,cnumber) values('$uid','$name','$number')"

        writableDatabase.execSQL(insQ)
    }

    fun insertdata(fullname: String, email: String, phono: String, pass: String) {
        var dd =
            "insert into MYDATA (NAME , PHONE , EMAIL , PASSWORD) Values('$fullname','$phono','$email','$pass')"
        writableDatabase.execSQL(dd)
    }


}