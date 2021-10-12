package com.example.android_bootcamp_anuj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.android_bootcamp_anuj.room.RoomDatabaseBuilder
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // insertDataInDBUsingSQLite()
        val addDummySqliteDemoBtn: Button = findViewById(R.id.addDummyRoomDataBtn)
        val sqliteDemoBtn:Button = findViewById(R.id.sqliteDemoBtn)
        sqliteDemoBtn.setOnClickListener {
            startActivity(
                Intent(this, DatabaseActivity::class.java)
            )
        }

        addDummySqliteDemoBtn.setOnClickListener {
            insertDataInDBUsingRoom()
            Toast.makeText(this, "Data added successfully", Toast.LENGTH_LONG).show()
        }
    }

    private fun insertDataInDBUsingRoom() {
        val database = RoomDatabaseBuilder.getInstance(this)

        Executors.newSingleThreadExecutor().execute {
            database.employeeDao().insertEmployeeDetails(
                EmployeeDataClass(
                    name = "Anuj",
                    contact = "9844556698",
                    address = "Uttarakhand"
                )
            )
            database.employeeDao().insertEmployeeDetails(
                EmployeeDataClass(
                    name = "Ankit",
                    contact = "9765498756",
                    address = "Uttarakhand"
                )
            )
            database.employeeDao().insertEmployeeDetails(
                EmployeeDataClass(
                    name = "Atul",
                    contact = "9688997752",
                    address = "Mumbai"
                )
            )

        }
    }

}