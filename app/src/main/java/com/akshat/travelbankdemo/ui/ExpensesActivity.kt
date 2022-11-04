package com.akshat.travelbankdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshat.travelbankdemo.R
import com.akshat.travelbankdemo.adapter.ExpenseListAdapter
import com.akshat.travelbankdemo.model.ExpenseResponse1Item
import com.akshat.travelbankdemo.presenter.EventsListener
import com.akshat.travelbankdemo.repository.ExpenseRepository
import com.akshat.travelbankdemo.utils.ConnectionDetector
import com.akshat.travelbankdemo.utils.alertDialog
import com.akshat.travelbankdemo.utils.dismissprogressDialog
import com.akshat.travelbankdemo.utils.showprogressDialog
import com.akshat.travelbankdemo.viewmodel.ExpenseViewModelFactory
import com.akshat.travelbankdemo.viewmodel.ExpensesViewModel

class ExpensesActivity : AppCompatActivity(), EventsListener {
    private lateinit var factory: ExpenseViewModelFactory
    private lateinit var viewModel: ExpensesViewModel
    private lateinit var cd: ConnectionDetector



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_expenses)
        cd = ConnectionDetector()
        val repository = ExpenseRepository()
        factory = ExpenseViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(ExpensesViewModel::class.java)
        val recyclerview = findViewById<RecyclerView>(R.id.recycler_view_data)

        if (cd.isConnectingToInternet(this)) {
            showprogressDialog(
                this,
                resources.getString(R.string.home_message),
                "",
                true
            )

            viewModel.getExpensesData()
            viewModel.expensesData.observe(this, Observer { expensesData ->
                recyclerview.also{
                    it.layoutManager = LinearLayoutManager(this)
                    it.setHasFixedSize(true)
                    if (expensesData != null) {
                        dismissprogressDialog(this)
                    }
                    it.adapter = ExpenseListAdapter(expensesData, this)
                }

            })


        }
        else{
            alertDialog(resources.getString(R.string.no_internet_string))
        }

    }

    override fun onExpenseClick(view: View, availableExpense: ExpenseResponse1Item) {
        // TO be implemented for moving to next poage
    }
}