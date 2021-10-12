package com.example.android_bootcamp_anuj.Sqlite

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.android_bootcamp_anuj.EmployeeData


class DatabaseManager(private val context: Context) {

    // Create object of DatabaseHelper class
    // which we have created
    private val databaseHelper =
        DatabaseHelper(context)

    private val TAG = "DB_MANAGER"

    fun insertValue(employeeDataClass: EmployeeData) {
        // get writable database as we want to write data
        val db = databaseHelper.writableDatabase

        //Content Values
        val contentValues = ContentValues()
        contentValues.put(DatabaseHelper.COLUMN_NAME, employeeDataClass.name)
        contentValues.put(DatabaseHelper.COLUMN_CONTACT, employeeDataClass.contact)
        contentValues.put(DatabaseHelper.COLUMN_ADDRESS, employeeDataClass.address)

        val id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues)

        Log.i(TAG, "Data inserted with Id: $id")

        // close the connection
        db.close()
    }

    // Get all data from SQLite DB
    @SuppressLint("Range")
    fun getAllEmpDataFromSQLiteDB(): ArrayList<EmployeeData> {
        // get writable database
        val db = databaseHelper.writableDatabase

        // Select All Query
        val selectQuery = "SELECT  * FROM " + DatabaseHelper.TABLE_NAME
        val cursor = db.rawQuery(selectQuery, null)

        val employeesList: ArrayList<EmployeeData> = arrayListOf()

        if (cursor.moveToFirst()) {
            do {

                val employee =
                    EmployeeData()
                employee.id =
                    cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID))
                employee.name =
                    cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME))
                employee.contact =
                    cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_CONTACT))
                employee.address =
                    cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_ADDRESS))

                employeesList.add(employee)

            } while (cursor.moveToNext())
        }
        cursor.close()

        return employeesList
    }

    fun updateAnEmployeeData(empID: Int, name: String, contact: String, address: String): Int {
        // get writable database
        val db = databaseHelper.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(DatabaseHelper.COLUMN_NAME, name)
        contentValues.put(DatabaseHelper.COLUMN_CONTACT, contact)
        contentValues.put(DatabaseHelper.COLUMN_ADDRESS, address)

        return db.update(
            DatabaseHelper.TABLE_NAME,
            contentValues,
            DatabaseHelper.COLUMN_ID + "=?",
            arrayOf(empID.toString())
        )
    }

    fun deleteAnEmployeeData(empID: Int): Int {
        // get writable database
        val db = databaseHelper.writableDatabase

        return db.delete(
            DatabaseHelper.TABLE_NAME,
            DatabaseHelper.COLUMN_ID + "=?",
            arrayOf(empID.toString())
        )
    }

}
