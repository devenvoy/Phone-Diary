package com.example.demoofflinedatabase

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.demoofflinedatabase.SlashScreen.Companion.editor
import com.google.android.material.textfield.TextInputEditText


class LoginPage : AppCompatActivity() {

    lateinit var uname: TextInputEditText
    lateinit var upass: TextInputEditText
    lateinit var stayLog: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        upass = findViewById(R.id.password)
        uname = findViewById(R.id.username)

    }

    fun newlog(view: View) {

        stayLog = findViewById(R.id.stayLog)

        var mydb = MyDatabsehelper(this@LoginPage)

        var cu = mydb.loginuser(uname.text.toString(), upass.text.toString())

        if (cu.moveToNext()) {
            if (stayLog.isChecked) {
                editor.putBoolean("StayLogged", true)
                editor.apply()
            }
            editor.putInt("uid", cu.getInt(0))
            editor.putString("Name", cu.getString(1))
            editor.putString("Email", cu.getString(2))
            editor.putString("Phone", cu.getString(3))
            editor.apply()
            mydb.TestLog()
            Toast.makeText(this@LoginPage, "LOGIN Successful", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@LoginPage, HomePage::class.java))
            finish()
        } else {
            Toast.makeText(this@LoginPage, "User-not Fount", Toast.LENGTH_SHORT).show()
        }

    }

    fun signup(view: View) {
        startActivity(Intent(this@LoginPage, SignUp::class.java))
        finish()
    }
}