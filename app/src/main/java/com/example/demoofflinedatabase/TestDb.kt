package com.example.demoofflinedatabase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class TestDb(context: Context?) : SQLiteOpenHelper(context, "Testdb.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {

        var qry = "CREATE TABLE TEST(ID INTEGER PRIMARY KEY  AUTOINCREMENT , NAME TEXT )"

        db!!.execSQL(qry)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun TestLog() {
        var logqry = "INSERT INTO TEST(NAME) VALUES(datetime('now'))"
        writableDatabase.execSQL(logqry)
    }
}