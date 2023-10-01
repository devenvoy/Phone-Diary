package com.example.demoofflinedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.demoofflinedatabase.SlashScreen.Companion.sp

class HomePage : AppCompatActivity() {

    lateinit var name : TextView
    lateinit var email : TextView
    lateinit var phone : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        phone = findViewById(R.id.phone)

        name.text = sp.getString("Name","").toString()
        email.text = sp.getString("Email","").toString()
        phone.text = sp.getString("Phone","").toString()

    }
}
