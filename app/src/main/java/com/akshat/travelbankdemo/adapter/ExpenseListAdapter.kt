package com.akshat.travelbankdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.akshat.travelbankdemo.R
import com.akshat.travelbankdemo.databinding.RecyclerViewExpensesBinding
import com.akshat.travelbankdemo.model.ExpenseResponse1Item
import com.akshat.travelbankdemo.presenter.EventsListener
import java.text.SimpleDateFormat
import java.util.*

class ExpenseListAdapter(
    private val expenseAvailable : List<ExpenseResponse1Item>,
    private val listner : EventsListener
) : RecyclerView.Adapter<ExpenseListAdapter.ExpensesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ExpensesViewHolder (
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recycler_view_expenses,
            parent,
            false
        )
    )

    override fun getItemCount()=expenseAvailable.size

    override fun onBindViewHolder(holder: ExpensesViewHolder, position: Int) {
        holder.recyclerViewExpenseBinding.expense = expenseAvailable[position]
        if(expenseAvailable[position].currencyCode!="")
        {
            holder.recyclerViewExpenseBinding.currency.isVisible = true
            holder.recyclerViewExpenseBinding.currency.text = expenseAvailable[position].currencyCode
        }
        ("$"+ expenseAvailable[position].amount).also { holder.recyclerViewExpenseBinding.amount.text = it }

        holder.recyclerViewExpenseBinding.root.setOnClickListener {
            listner.onExpenseClick(
                holder.recyclerViewExpenseBinding.root,
                expenseAvailable[position]
            )
        }

    }


    inner class ExpensesViewHolder(
        val recyclerViewExpenseBinding: RecyclerViewExpensesBinding
    ):RecyclerView.ViewHolder(recyclerViewExpenseBinding.root)
}