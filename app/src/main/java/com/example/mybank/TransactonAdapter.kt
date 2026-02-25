package com.example.mybank // Убедись, что пакет твой

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TransactionAdapter(private val transactions: List<Transaction>) :
    RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

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

    // ВАЖНО: Связываем данные
    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction = transactions[position]

        holder.title.text = transaction.title
        holder.amount.text = transaction.amount
        holder.date.text = transaction.date

        // Маленький бонус: красим сумму. Если минус — красный, если плюс — зеленый.
        if (transaction.amount.contains("-")) {
            holder.amount.setTextColor(android.graphics.Color.RED)
        } else {
            holder.amount.setTextColor(android.graphics.Color.GREEN) // Или цвет по умолчанию
        }
    }

    // ВАЖНО: Говорим, сколько элементов
    override fun getItemCount(): Int {
        return transactions.size
    }
}