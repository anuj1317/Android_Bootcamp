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
            Thread.sleep(500)
        }
        catch (e: Exception) {
            Toast.makeText(context, "Exception: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
        }
    }



}