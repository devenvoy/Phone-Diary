package com.example.demoofflinedatabase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class LoginPage : AppCompatActivity() {
    var gender = "male" ;

    lateinit var male: RadioButton
    lateinit var panipuri: CheckBox
    lateinit var female: RadioButton
    lateinit var radioGroup: RadioGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        male = findViewById(R.id.male)
        female = findViewById(R.id.female)
        radioGroup = findViewById(R.id.radiogroup)
        panipuri = findViewById(R.id.panipuri)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId==R.id.male)
            {
                gender = "male"
            }
            if (checkedId==R.id.female)
            {
                gender = "female"
            }
        }

    }


    fun newlog(view: View) {
        startActivity(Intent(this@LoginPage, SignUp::class.java))
    }

    fun myintent(view: View) {

        Log.d("====", "myintent: $gender")
        if(panipuri.isChecked)
        {
            Log.d("====", "myintent: ${panipuri.text}")
        }



    }
}