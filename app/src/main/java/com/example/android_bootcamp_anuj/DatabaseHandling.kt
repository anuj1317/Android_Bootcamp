package com.example.android_bootcamp_anuj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_bootcamp_anuj.Sqlite.DatabaseManager

class DatabaseHandling : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    private lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database_handling)


        initRecyclerView()

    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.rv_employeedetails)

        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager

            setupListFromSQLite()
            recyclerView.adapter = customAdapter
            customAdapter.notifyDataSetChanged()


    }



    private fun setupListFromSQLite() {
        val databaseManager =
            DatabaseManager(this)

        // get data from Database
        val employeeList = databaseManager.getAllEmpDataFromSQLiteDB()

        customAdapter =
            CustomAdapter(this, employeeList)
    }
}