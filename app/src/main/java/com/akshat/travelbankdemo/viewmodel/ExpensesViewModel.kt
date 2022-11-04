package com.akshat.travelbankdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akshat.travelbankdemo.model.ExpenseResponse1Item
import com.akshat.travelbankdemo.repository.ExpenseRepository
import com.akshat.travelbankdemo.utils.ApiExceptions
import com.akshat.travelbankdemo.utils.Constants
import com.akshat.travelbankdemo.utils.Coroutines

class ExpensesViewModel(
    private val repository: ExpenseRepository
) : ViewModel() {
    private val _expenseData = MutableLiveData<List<ExpenseResponse1Item>>()
    val expensesData: LiveData<List<ExpenseResponse1Item>>
        get() = _expenseData


    fun getExpensesData(){
        Coroutines.main {
            try {
                val url = Constants.endPoint
                val authResponse = repository.getExpensesData(url)
                _expenseData.value = authResponse
                return@main
            } catch (e: ApiExceptions) {
                //   authListener?.onFailure(e.message!!)
            }
        }
    }



}