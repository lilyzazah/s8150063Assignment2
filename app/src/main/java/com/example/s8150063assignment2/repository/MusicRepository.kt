package com.example.s8150063assignment2.repository

import com.example.s8150063assignment2.data.DashboardResponse
import com.example.s8150063assignment2.network.RetrofitClient
import retrofit2.Call

class MusicRepository {

    fun getDashboard(
        keypass: String
    ): Call<DashboardResponse> {

        return RetrofitClient
            .apiService
            .getDashboard(keypass)
    }
}