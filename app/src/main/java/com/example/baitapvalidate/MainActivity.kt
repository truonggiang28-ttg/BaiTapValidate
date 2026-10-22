package com.example.baitapvalidate

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtName = findViewById<EditText>(R.id.edtName)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPhone = findViewById<EditText>(R.id.edtPhone)
        val edtMsv = findViewById<EditText>(R.id.edtMsv)
        val edtClass = findViewById<EditText>(R.id.edtClass)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val name = edtName.text.toString().trim()
            val email = edtEmail.text.toString().trim()
            val phone = edtPhone.text.toString().trim()
            val msv = edtMsv.text.toString().trim()
            val className = edtClass.text.toString().trim()



            // Nếu Pass hết Validation -> Gọi Intent
            val intent = Intent(this, DetailsActivity::class.java).apply {
                putExtra("EXTRA_NAME", name)
                putExtra("EXTRA_EMAIL", email)
                putExtra("EXTRA_PHONE", phone)
                putExtra("EXTRA_MSV", msv)
                putExtra("EXTRA_CLASS", className)
            }
            startActivity(intent)
        }
    }
}