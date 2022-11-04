package com.akshat.travelbankdemo.repository

import com.akshat.travelbankdemo.model.*
import com.akshat.travelbankdemo.network.ExpensesApi
import com.akshat.travelbankdemo.utils.SafeAPIRequest


class ExpenseRepository : SafeAPIRequest() {
    suspend fun getExpensesData(url : String) : List<ExpenseResponse1Item> {
        return apiRequest { ExpensesApi().getExpensesData(url)}
    }
}