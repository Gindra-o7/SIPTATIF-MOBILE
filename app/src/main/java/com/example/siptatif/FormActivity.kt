package com.example.siptatif

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        setupView()
        setupAutoCompleteTextView()
        setupSendButton()
    }

    fun onBackClicked(view: View) {
        val intent = Intent(this, NavigationActivity::class.java)
        startActivity(intent)
    }

    private fun setupView() {
    }

    private fun setupAutoCompleteTextView() {
        val autoCompletePendaftaran: AutoCompleteTextView = findViewById(R.id.auto_completePendaftaran)
        val pendaftaranItems = listOf(
            "Individu",
            "Kelompok"
        )
        val pendaftaranAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, pendaftaranItems)
        autoCompletePendaftaran.setAdapter(pendaftaranAdapter)

        val autoCompleteKategori: AutoCompleteTextView = findViewById(R.id.auto_completeKategori)
        val kategoriItems = listOf(
            "Laporan",
            "Kategori 2",
            "Kategori 3"
        )
        val kategoriAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, kategoriItems)
        autoCompleteKategori.setAdapter(kategoriAdapter)

        val autoCompleteCalonPembimbing1: AutoCompleteTextView = findViewById(R.id.auto_completecalonPembimbing1)
        val calonPembimbingItems = listOf(
            "Dr. Fulanah, S.T., M.Kom.",
            "Prof. Dr. Fikri Fulan",
            "Dr. Farida Fulanah",
            "Prof. Dr. Firdaus Fulandari"
        )
        val calonPembimbingAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, calonPembimbingItems)
        autoCompleteCalonPembimbing1.setAdapter(calonPembimbingAdapter)

        val autoCompleteCalonPembimbing2: AutoCompleteTextView = findViewById(R.id.auto_completecalonPembimbing2)
        autoCompleteCalonPembimbing2.setAdapter(calonPembimbingAdapter)
    }

    private fun setupSendButton() {
        val sendButton: Button = findViewById(R.id.btn_send)
        sendButton.setOnClickListener {
        }
    }
}
