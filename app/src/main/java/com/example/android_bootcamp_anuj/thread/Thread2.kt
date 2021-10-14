package com.example.android_bootcamp_anuj.thread

import android.content.Context
import android.util.Log
import android.widget.Toast
import java.lang.Exception

class Thread2(private val context: Context): Thread() {

    val TAG = "thread2"

    override fun run() {
        super.run()

        for (i in 1..5) {
            Log.i(TAG, "is running, Iteration: $i")
        }

        try {
            Thread.sleep(200)
            Toast.makeText(context,"Thread 2 Started",Toast.LENGTH_SHORT).show()
        }
        catch (e: Exception) {
//            Toast.makeText(context, "Exception", Toast.LENGTH_SHORT).show()
        }
    }



}