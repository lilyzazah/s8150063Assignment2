package com.example.s8150063assignment2.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.s8150063assignment2.R
import android.content.Intent
import android.widget.Button
import com.example.s8150063assignment2.ui.dashboard.DashboardActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
    }
}