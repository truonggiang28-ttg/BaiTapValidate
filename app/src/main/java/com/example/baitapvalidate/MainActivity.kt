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

            // Bắt đầu Validation
            var isValid = true

            // Kiểm tra Họ tên
            if (name.isEmpty()) {
                edtName.error = "Không được để trống họ tên!"
                isValid = false
            }

            // Kiểm tra Email
            if (email.isEmpty()) {
                edtEmail.error = "Không được để trống email!"
                isValid = false
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                edtEmail.error = "Email không hợp lệ!"
                isValid = false
            }

            // Kiểm tra Số điện thoại
            if (phone.isEmpty()) {
                edtPhone.error = "Không được để trống số điện thoại!"
                isValid = false
            } else if (phone.length < 10 || !phone.matches(Regex("^[0-9]+$"))) {
                edtPhone.error = "Số điện thoại phải từ 10 số hợp lệ!"
                isValid = false
            }

            // Kiểm tra Mã sinh viên
            if (msv.isEmpty()) {
                edtMsv.error = "Không được để trống mã sinh viên!"
                isValid = false
            }

            // Kiểm tra Lớp
            if (className.isEmpty()) {
                edtClass.error = "Không được để trống lớp!"
                isValid = false
            }

            // Nếu có bất kỳ ô nào bị lỗi thì dừng lại, không chuyển trang
            if (!isValid) {
                return@setOnClickListener
            }

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