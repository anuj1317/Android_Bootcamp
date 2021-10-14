package com.example.android_bootcamp_anuj.thread

import android.content.Context
import android.util.Log
import android.widget.Toast
import java.lang.Exception

class Thread1(private val context: Context): Thread() {

    val TAG = "thread1"

    override fun run() {
        super.run()
        Log.i(TAG, " is running")

        try {
            Thread.sleep(500)
            Toast.makeText(context,"Thread 1 Started",Toast.LENGTH_SHORT).show()
        }
        catch (e: Exception) {
//            Toast.makeText(context, "Exception: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
        }
    }


}