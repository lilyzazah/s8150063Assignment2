package com.example.s8150063assignment2

import com.example.s8150063assignment2.viewmodel.DashboardViewModel
import org.junit.Assert.assertNotNull
import org.junit.Test

class DashboardViewModelTest {

    @Test
    fun viewModel_isCreated() {

        val viewModel = DashboardViewModel()

        assertNotNull(viewModel)
    }

    @Test
    fun repository_isNotNull() {

        val viewModel = DashboardViewModel()

        assertNotNull(viewModel)
    }
}