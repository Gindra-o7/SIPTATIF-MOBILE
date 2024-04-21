package com.example.siptatif

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button


class ConfirmEmailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_email)
        supportActionBar?.hide()

        val btnSend: Button = findViewById(R.id.ce_btn_1)

        btnSend.setOnClickListener{
            val intent = Intent(this, NewPasswordActivity::class.java)
            startActivity(intent)
        }

    }

    fun onLoginClicked2(view: View){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}