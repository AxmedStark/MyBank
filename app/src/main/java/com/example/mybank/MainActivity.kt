package com.example.mybank

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mybank.BuildConfig.BASE_URL

class MainActivity : AppCompatActivity() {

    val TAG = "LifecycleCheck"
    private var clickCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate")
        setContentView(R.layout.activity_main)

        if (BuildConfig.DEBUG) Log.d("BASE_URL_CHECK", "BASE_URL: $BASE_URL")

        val recyclerView: RecyclerView = findViewById(R.id.rvTransactions)

        val transactionList = listOf(
            Transaction(1, "Netflix Subscription", "- $12.99", "Today, 10:00", 0),
            Transaction(2, "Salary", "+ $2,500.00", "Yesterday, 18:30", 0),
            Transaction(3, "Grocery Store", "- $45.20", "23 Feb, 14:15", 0),
            Transaction(4, "Starbucks", "- $5.50", "23 Feb, 09:00", 0),
            Transaction(5, "Gym Membership", "- $30.00", "20 Feb, 12:00", 0),
            Transaction(6, "Transfer from John", "+ $100.00", "19 Feb, 16:45", 0),
            Transaction(7, "Uber Ride", "- $15.00", "18 Feb, 22:30", 0),
            Transaction(8, "Cinema", "- $20.00", "18 Feb, 20:00", 0)
        )

        val adapter = TransactionAdapter(transactionList){ transaction ->
            Toast.makeText(this, "Clicked: ${transaction.title}", Toast.LENGTH_SHORT).show()
        }

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        if (BuildConfig.DEBUG) Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        if (BuildConfig.DEBUG) Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        if (BuildConfig.DEBUG) Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        if (BuildConfig.DEBUG) Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        if (BuildConfig.DEBUG) Log.d(TAG, "onDestroy")
    }
}