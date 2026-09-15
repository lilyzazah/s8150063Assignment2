package com.example.s8150063assignment2.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.s8150063assignment2.R
import android.content.Intent
import android.widget.Button
import com.example.s8150063assignment2.ui.dashboard.DashboardActivity


import android.widget.EditText
import android.widget.Toast
import com.example.s8150063assignment2.data.LoginRequest
import com.example.s8150063assignment2.data.LoginResponse
import com.example.s8150063assignment2.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {

            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if(username.isBlank() || password.isBlank()) {

                Toast.makeText(
                    this,
                    "Please enter Student ID and First Name",
                    Toast.LENGTH_LONG
                ).show()

                return@setOnClickListener
            }

            val request = LoginRequest(
                username = username,
                password = password
            )

            RetrofitClient.apiService.login(request)
                .enqueue(object : Callback<LoginResponse> {

                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {

                        if (response.isSuccessful) {

                            val keypass =
                                response.body()?.keypass ?: ""

                            Toast.makeText(
                                this@LoginActivity,
                                "Login Successful",
                                Toast.LENGTH_SHORT
                            ).show()

                            val intent = Intent(
                                this@LoginActivity,
                                DashboardActivity::class.java
                            )

                            intent.putExtra(
                                "KEYPASS",
                                keypass
                            )

                            startActivity(intent)

                        } else {

                            Toast.makeText(
                                this@LoginActivity,
                                "Invalid Student ID or First Name",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(
                        call: Call<LoginResponse>,
                        t: Throwable
                    ) {

                        Toast.makeText(
                            this@LoginActivity,
                            t.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
        }
    }
}
