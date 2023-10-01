package com.example.demoofflinedatabase

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class SignUp : AppCompatActivity() {

    lateinit var exit: ImageView
    lateinit var logintxt: TextView
    lateinit var signup: Button
    var canLogin: Boolean = false
    lateinit var passlay: TextInputLayout
    lateinit var cpasslay: TextInputLayout
    lateinit var emaillay: TextInputLayout
    lateinit var reg_fname: EditText
    lateinit var reg_lname: EditText
    lateinit var reg_email: EditText
    lateinit var reg_phone: EditText
    lateinit var reg_password: EditText
    lateinit var reg_cpassword: EditText

    override fun onBackPressed() {
        startActivity(Intent(this@SignUp, LoginPage::class.java))
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        exit = findViewById(R.id.backbtn)
        logintxt = findViewById(R.id.logintxt)
        signup = findViewById(R.id.signup)
        reg_fname = findViewById(R.id.reg_fname)
        reg_lname = findViewById(R.id.reg_lname)
        reg_email = findViewById(R.id.reg_email)
        reg_phone = findViewById(R.id.reg_phone)
        reg_password = findViewById(R.id.reg_password)
        reg_cpassword = findViewById(R.id.reg_cpassword)
        passlay = findViewById(R.id.passlay)
        cpasslay = findViewById(R.id.cpasslay)
        emaillay = findViewById(R.id.emaillay)

        exit.setOnClickListener {
            startActivity(Intent(this@SignUp, LoginPage::class.java))
            finish()
        }

        logintxt.setOnClickListener {
            startActivity(Intent(this@SignUp, LoginPage::class.java))
            finish()
        }

        // set helper for while filling email block
        reg_email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                val EMAIL_REGEX = "^[a-z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-z.-]+$"
                val pattern = Pattern.compile(EMAIL_REGEX)
                val email: String = reg_email.text.toString()
                if (!pattern.matcher(email).matches()) {
                    emaillay.helperText = "Invalid email"
                } else {
                    canLogin = true
                    emaillay.helperText = ""
                }
            }
        })

        // set helper for to filling password block
        reg_password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(s: Editable) {
                val input = s.toString()
                val errorMessage = errorMsg(input)
                if (errorMessage == "Field Empty") {
                    passlay.helperText = "Enter Valid Password"
                } else {
                    passlay.helperText = errorMessage
                }
                if (errorMessage == "Strong Password") {
                    passlay.setHelperTextColor(ColorStateList.valueOf(resources.getColor(R.color.LimeGreenNeon)))
                    canLogin = true
                }
            }
        })

        signup.setOnClickListener {

            val fname = reg_fname.text.toString()
            val lname: String = reg_lname.text.toString()
            val fullname = "$fname $lname"
            val email: String = reg_email.text.toString()
            val phono: String = reg_phone.text.toString()
            val pass: String = reg_password.text.toString()
            val cpass: String = reg_cpassword.text.toString()

            var data = MyDatabsehelper(this@SignUp)



            canLogin = if (fname.isEmpty()) {
                reg_fname.error = "Fill this field"
                false
            } else {
                true
            }
            canLogin = if (lname.isEmpty()) {
                reg_lname.error = "Fill this field"
                false
            } else {
                true
            }
            canLogin = if (email.isEmpty()) {
                reg_email.error = "Fill this field"
                false
            } else {
                val cur = data.checkUser(email)
                if (cur.moveToNext()) {
                    Toast.makeText(this@SignUp, "User available", Toast.LENGTH_SHORT).show()
                    false
                } else {
                    true
                }
            }
            canLogin = if (phono.isEmpty()) {
                reg_phone.error = "Fill this field"
                false
            } else {
                true
            }
            canLogin = if (pass.isEmpty()) {
                reg_password.error = "Fill this Field"
                passlay.helperText = "Enter Password"
                false
            } else {
                true
            }
            if (canLogin) {
                if (pass == cpass) {

                    var myDatabsehelper = MyDatabsehelper(this@SignUp)


                    // this will call database class with  insertdata function to  store offline data in table
                    myDatabsehelper.insertdata(fullname, email, phono, pass)

                    // if validation correct than add record in table and goes to Login Page for login
                    Toast.makeText(this@SignUp, "Login Successful", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@SignUp, LoginPage::class.java))
                    finish()
                } else {
                    cpasslay.helperText = "Password did not match"
                }
            } else {
                Toast.makeText(this@SignUp, "Fill form correctly", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // error message to set in helper text to guild what need to be fill in this block
    fun errorMsg(input: String?): String {
        if (input.isNullOrEmpty()) {
            return "Field Empty"
        }
        val hasSpecialChar = input.matches(".*[@#$%_].*".toRegex())
        var hasCapitalLetter = false
        for (c in input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasCapitalLetter = true
                break
            }
        }
        val errorMessage: String = if (!hasCapitalLetter) {
            "At least one capital letter is required."
        } else if (input.length < 8) {
            "Length Minimum 8 characters"
        } else if (input.length > 16) {
            "Length Maximum 16 characters"
        } else if (!hasSpecialChar) {
            "Include one special character @, #, $, %, or _."
        } else {
            "Strong Password"
        }
        return errorMessage
    }

}