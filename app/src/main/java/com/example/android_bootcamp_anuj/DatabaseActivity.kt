package com.example.android_bootcamp_anuj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_bootcamp_anuj.room.RoomDatabaseBuilder
import java.util.concurrent.Executors

class DatabaseActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    private lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)

        initialiseRecyclerView()

    }

    private fun initialiseRecyclerView() {
        recyclerView = findViewById(R.id.employeeDetailsRecyclerView)

        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        setupListFromRoom()
    }



    private fun setupListFromRoom() {
        val roomDatabaseBuilder = RoomDatabaseBuilder.getInstance(this)
        var employeeList: List<EmployeeDataClass>

        Executors.newSingleThreadExecutor().execute {
            // get data from Database
            employeeList = roomDatabaseBuilder.employeeDao().getAllEmployeeDetails()

            recyclerView.apply {
                // Stuff that updates the UI
                runOnUiThread {
                    customAdapter =
                        CustomAdapter(
                            this@DatabaseActivity,
                            employeeList as ArrayList<EmployeeDataClass>
                        )
                    recyclerView.adapter = customAdapter
                    customAdapter.notifyDataSetChanged()
                }
            }
        }
    }
}