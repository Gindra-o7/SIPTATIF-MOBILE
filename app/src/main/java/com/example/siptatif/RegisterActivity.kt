package com.example.siptatif

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.hide()

        val btnRegis: Button = findViewById(R.id.R_btn_1)

        btnRegis.setOnClickListener{
            val intent = Intent(this, OtpActivity::class.java)
            startActivity(intent)
        }

    }

    fun onBackClicked2(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun onLoginClicked(view: View){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}