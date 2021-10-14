package com.example.android_bootcamp_anuj.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast
import com.example.android_bootcamp_anuj.R

class MyMusicService: Service() {

    private lateinit var mediaPlayer: MediaPlayer
    //For Binding Service with an Activity
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

////
//    override fun onCreate() {
//        super.onCreate()
//        Toast.makeText(this, "Service created", Toast.LENGTH_SHORT).show()
//    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "Service started", Toast.LENGTH_SHORT).show()
        mediaPlayer = MediaPlayer.create(this, R.raw.tune)
        mediaPlayer.isLooping = false
        mediaPlayer.start()
        return START_STICKY

    }



//    override fun onStart(intent: Intent?, startId: Int) {
//        Toast.makeText(this, "Service started", Toast.LENGTH_SHORT).show()
//        mediaPlayer.start()
//    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "service stopped", Toast.LENGTH_SHORT).show()
        mediaPlayer.stop()

    }











}