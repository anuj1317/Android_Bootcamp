package com.example.android_bootcamp_anuj.Sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "employee_db", null, 1) {

    companion object {
        const val TABLE_NAME = "employee_table"
        const val COLUMN_ID = "emp_id"
        const val COLUMN_NAME = "emp_name"
        const val COLUMN_CONTACT = "emp_contact"
        const val COLUMN_ADDRESS = "emp_address"

        // Create table SQL query
        const val CREATE_TABLE_QUERY =
            ("CREATE TABLE IF NOT EXISTS $TABLE_NAME " +
                    "($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$COLUMN_NAME TEXT, " +
                    "$COLUMN_CONTACT TEXT, " +
                    "$COLUMN_ADDRESS TEXT)")
    }


    override fun onCreate(db: SQLiteDatabase?) {
        // execute query to create table
        db?.execSQL(CREATE_TABLE_QUERY)
    }

    // To alter the table use this method
    // Eg. Dropping table
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}
