package com.example.s8150063assignment2.viewmodel

import androidx.lifecycle.ViewModel
import com.example.s8150063assignment2.repository.MusicRepository

class DashboardViewModel : ViewModel() {

    private val repository =
        MusicRepository()

    fun getDashboard(
        keypass: String
    ) = repository.getDashboard(keypass)
}