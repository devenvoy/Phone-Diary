package com.example.demoofflinedatabase

import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SlashScreen : AppCompatActivity() {


    companion object {

        lateinit var sp: SharedPreferences
        lateinit var editor: Editor


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slash_screen)


        Handler().postDelayed({
            sp = getSharedPreferences("LoggedData", MODE_PRIVATE)
            editor = sp.edit()

            if (sp.getBoolean("StayLogged", false)) {
                val testdb = TestDb(this@SlashScreen)
                testdb.TestLog()
                startActivity(Intent(this@SlashScreen, HomePage::class.java))
                finish()
            } else {
                startActivity(Intent(this@SlashScreen, LoginPage::class.java))
                finish()
            }
        }, 3000)
    }
}