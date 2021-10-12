package com.example.android_bootcamp_anuj

import SharedPrefUtil
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.android_bootcamp_anuj.Sqlite.DatabaseManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val addDataBtn= findViewById<Button>(R.id.adddata)
        val sqliteDemoBtn = findViewById<Button>(R.id.sqliteDemo)
        sqliteDemoBtn.setOnClickListener {
            startActivity(
                Intent(this, DatabaseHandling::class.java)
            )
        }

        addDataBtn.setOnClickListener {
            insertDataSQLite()
            Toast.makeText(this, "Data added successfully", Toast.LENGTH_LONG).show()
        }
        textView = findViewById(R.id.textview2)

        logoutbtn.setOnClickListener {

            var sharedPreferences: SharedPrefUtil = SharedPrefUtil(this)
            sharedPreferences.clearPref()
            sharedPreferences.clearPref()
            intent = Intent(this, Login::class.java)
            startActivity(intent)

        }


    }

    private fun insertDataSQLite() {

        val databaseManager =
            DatabaseManager(this)

        // insert data in DB
        databaseManager.insertValue(
            EmployeeData(
                name = "Anuj",
                contact = "9355446655",
                address = "Uttarakhand"
            )
        )
        databaseManager.insertValue(
            EmployeeData(
                name = "Ankit",
                contact = "9966554789",
                address = "Delhi"
            )
        )
        databaseManager.insertValue(
            EmployeeData(
                name = "Atul",
                contact = "9655447791",
                address = "Mumbai"
            )
        )
        databaseManager.insertValue(
            EmployeeData(
                name = "Akash",
                contact = "9564598745",
                address = "Rajasthan"
            )
        )
    }


    override fun onStart() {
        super.onStart()
        checkUserStatus()
    }

    private fun checkUserStatus() {
        var sharedPreferences: SharedPrefUtil = SharedPrefUtil(this)
        val name:String? =  sharedPreferences.getPreference(SharedPrefUtil.KEY_EMAIL,"Logout")
        val Counter:Boolean =  sharedPreferences.getPreference(SharedPrefUtil.KEY_IS_LOOGGED_IN,defaultValue = true)

        if(name!=null && name != "Logout"){
            textView.text = name

        }else{
            intent = Intent(this, Login::class.java)
            startActivity(intent)

        }
    }

}
