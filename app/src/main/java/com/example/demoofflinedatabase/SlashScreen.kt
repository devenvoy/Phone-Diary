package com.example.demoofflinedatabase

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SlashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slash_screen)


        Handler().postDelayed(object : Runnable {
            override fun run() {
                startActivity(Intent(this@SlashScreen, LoginPage::class.java))
            }

        }, 3000)
    }
}