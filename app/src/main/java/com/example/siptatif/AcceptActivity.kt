package com.example.siptatif

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class AcceptActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accept)

    }

    fun onBackClicked(view: View) {
        val intent = Intent(this, NavigationActivity::class.java)
        startActivity(intent)
    }
}