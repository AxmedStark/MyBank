package com.example.mybank

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TransactionAdapter(
    private val transactions: List<Transaction>,
    private val onTransactionClick: (Transaction) -> Unit
) : RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    class TransactionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tvTitle)
        val amount: TextView = view.findViewById(R.id.tvAmount)
        val date: TextView = view.findViewById(R.id.tvDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_transaction, parent, false)
        return TransactionViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction = transactions[position]

        holder.title.text = transaction.title
        holder.amount.text = transaction.amount
        holder.date.text = transaction.date

        if (transaction.amount.contains("-")) {
            holder.amount.setTextColor(android.graphics.Color.RED)
        } else {
            holder.amount.setTextColor(android.graphics.Color.GREEN)
        }

        holder.itemView.setOnClickListener {
            onTransactionClick(transaction)
        }
    }

    override fun getItemCount(): Int {
        return transactions.size
    }
}