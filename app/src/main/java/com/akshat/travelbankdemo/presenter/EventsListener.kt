package com.akshat.travelbankdemo.presenter

import android.view.View
import com.akshat.travelbankdemo.model.ExpenseResponse1Item

interface EventsListener {
    fun onExpenseClick(view: View, availableExpense: ExpenseResponse1Item)
}