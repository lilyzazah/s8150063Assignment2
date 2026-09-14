package com.example.s8150063assignment2.network

import com.example.s8150063assignment2.data.LoginRequest
import com.example.s8150063assignment2.data.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import com.example.s8150063assignment2.data.DashboardResponse
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @POST("footscray/auth")
    fun login(
        @Body request: LoginRequest
    ): Call<LoginResponse>

    @GET("dashboard/{keypass}")
    fun getDashboard(
        @Path("keypass") keypass: String
    ): Call<DashboardResponse>
}