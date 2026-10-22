package com.example.baitapvalidate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Ánh xạ các thành phần giao diện mới
        val tvName = findViewById<TextView>(R.id.tvName)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val tvPhone = findViewById<TextView>(R.id.tvPhone)
        val tvMsv = findViewById<TextView>(R.id.tvMsv)
        val tvClass = findViewById<TextView>(R.id.tvClass)
        val btnBack = findViewById<Button>(R.id.btnBack)

        tvName.text = intent.getStringExtra("EXTRA_NAME") ?: "Không có dữ liệu"
        tvEmail.text = intent.getStringExtra("EXTRA_EMAIL") ?: "Không có dữ liệu"
        tvPhone.text = intent.getStringExtra("EXTRA_PHONE") ?: "Không có dữ liệu"
        tvMsv.text = intent.getStringExtra("EXTRA_MSV") ?: "Không có dữ liệu"
        tvClass.text = intent.getStringExtra("EXTRA_CLASS") ?: "Không có dữ liệu"

        btnBack.setOnClickListener {
            finish()
        }
    }
}