package com.example.android_bootcamp_anuj

import android.content.*
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.android_bootcamp_anuj.broadcast.BatteryStatusReceiver
import com.example.android_bootcamp_anuj.service.BoundService
import com.example.android_bootcamp_anuj.service.MyMusicService
import com.example.android_bootcamp_anuj.thread.Thread1
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    companion object {
        private const val PHONE_PERMISSION_CODE = 101
    }

    lateinit var batteryStatusReceiver: BatteryStatusReceiver
    var myService: BoundService? = null
    var isBound = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Broadcast Receiver
        receiverbtn.setOnClickListener {
            receiverDemoFunction()
            checkPermission(
                android.Manifest.permission.READ_PHONE_STATE,
                PHONE_PERMISSION_CODE)
        }

        val myThread1 = Thread1()
        val myThread2 = Thread1()
        val myThread3 = Thread1()

        // thread t1 starts

        myThread1.start()

        // starts second thread when first thread t1 is died.
        try {
            myThread1.join()
        } catch (e: Exception) {
            println(e)
        }
        // start t2 and t3 thread
        // start t2 and t3 thread
        myThread2.start()
        myThread3.start()


        //Service
        service()
       //bind
        bindLocalService()

        localServiceBtn.setOnClickListener {
            showTime()
        }

    }



    private fun bindLocalService() {
        val intent = Intent(this, BoundService::class.java)
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE)
    }

    private fun showTime() {
        val currentTime = myService?.getCurrentTime()
        Toast.makeText(this, "Current time is: ${currentTime.toString()}", Toast.LENGTH_SHORT)
            .show()
    }


    private val myConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            val binder = service as BoundService.MyLocalBinder
            myService = binder.getService()
            isBound = true
        }

        override fun onServiceDisconnected(name: ComponentName) {
            isBound = false
        }
    }


    private fun service() {
            val serviceIntent = Intent(this, MyMusicService::class.java)
            serviceStartBtn.setOnClickListener {
                startService(serviceIntent)
            }
            serviceStopBtn.setOnClickListener {
                stopService(serviceIntent)
            }
        }


        //Broadcast Receiver Function
        private fun receiverDemoFunction() {
            batteryStatusReceiver = BatteryStatusReceiver()
            registerReceiver(batteryStatusReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
        }

        //Unregister Broadcast Receiver
        override fun onStop() {
            super.onStop()
            unregisterReceiver(batteryStatusReceiver)
            unbindService(myConnection)

        }








    //Permission Handling
    private fun checkPermission(permission: String, requestCode: Int) {
        if (ContextCompat.checkSelfPermission(this@MainActivity, permission) == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(permission), requestCode)
        } else {
            Toast.makeText(this@MainActivity, "Permission already granted", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PHONE_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@MainActivity, "PHONE Permission Granted", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val intent = Intent(
                    ACTION_APPLICATION_DETAILS_SETTINGS,
                    Uri.fromParts("package", packageName, null)
                )
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)

            }
        }
    }












    }
