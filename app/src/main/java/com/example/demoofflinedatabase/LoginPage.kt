package com.example.demoofflinedatabase

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText


class LoginPage : AppCompatActivity() {
    var gender = "male";

    lateinit var male: RadioButton
    lateinit var uname: TextInputEditText
    lateinit var upass: TextInputEditText
    lateinit var signin: Button
    lateinit var panipuri: CheckBox
    lateinit var female: RadioButton
    lateinit var radioGroup: RadioGroup

    var dbhelper = TestDb(this@LoginPage)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        upass = findViewById(R.id.password)
        uname = findViewById(R.id.username)


//        male = findViewById(R.id.male)
//        female = findViewById(R.id.female)
//        radioGroup = findViewById(R.id.radiogroup)
//        panipuri = findViewById(R.id.panipuri)


//        radioGroup.setOnCheckedChangeListener { _, checkedId ->
//            if (checkedId==R.id.male)
//            {
//                gender = "male"
//            }
//            if (checkedId==R.id.female)
//            {
//                gender = "female"
//            }
//        }

    }


    fun newlog(view: View) {

        var mydb = MyDatabsehelper(this@LoginPage)

        var cu = mydb.loginuser(uname.text.toString(), upass.text.toString())

        if (cu.moveToNext()) {
            Toast.makeText(this@LoginPage, "LOGINNNN", Toast.LENGTH_SHORT).show()

        }
        else {
            Toast.makeText(this@LoginPage, "Usernot Fount", Toast.LENGTH_SHORT).show()

        }

//        startActivity(Intent(this@LoginPage, SignUp::class.java))
//        dbhelper.TestLog()
    }

    fun signup(view: View) {
        startActivity(Intent(this@LoginPage, SignUp::class.java))

    }
//        startActivity(Intent(this@LoginPage, SignUp::class.java))

//    fun myintent(view: View) {
//
//        Log.d("====", "myintent: $gender")
//        if(panipuri.isChecked)
//        {
//            Log.d("====", "myintent: ${panipuri.text}")
//        }
//    }
}