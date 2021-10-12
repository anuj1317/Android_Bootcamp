package com.example.android_bootcamp_anuj.room

import androidx.room.*
import com.example.android_bootcamp_anuj.EmployeeDataClass

@Dao
interface RoomEmployeeDoa {

    @Query("SELECT * FROM emp_table")
    fun getAllEmployeeDetails(): List<EmployeeDataClass>

    @Insert
    fun insertEmployeeDetails(employee: EmployeeDataClass)

    @Update
    fun updateEmployeeDetails(employee: EmployeeDataClass)

    @Delete
    fun deleteEmployeeDetails(employee: EmployeeDataClass)
}