package com.example.salary2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.user_registration.*

class LoginActivity : AppCompatActivity() {

    lateinit var handler : DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        handler= DatabaseHelper(this)
        showHome()
        registration.setOnClickListener {
            showRegistration()
        }
        save.setOnClickListener {
            handler.insertUserData(name.text.toString(),email.text.toString(),password_register.text.toString())
            Toast.makeText(this,"Save Success", Toast.LENGTH_SHORT).show()
            name.text.clear()
            email.text.clear()
            password_register.text.clear()
            showHome()
        }

        login_button.setOnClickListener {
            if ( handler.userPresent(login_email.text.toString(),login_password.text.toString())) {
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@LoginActivity,MainActivity::class.java))
            }
            else
                Toast.makeText(this,"Username or Password is incorrect", Toast.LENGTH_SHORT).show()
            login_email.text.clear()
            login_password.text.clear()
        }

    }
    private fun showRegistration(){
        registration_layout.visibility = View.VISIBLE
        home_11.visibility = View.GONE
    }

    private fun showHome(){
        registration_layout.visibility = View.GONE
        home_11.visibility = View.VISIBLE
    }
}