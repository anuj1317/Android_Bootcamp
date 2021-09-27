package com.example.android_bootcamp_anuj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle



fun main(args: Array<String>){
    //lambda function
    val SI = {p: Int, r: Int, t:Int -> (p*r*t)/100}
    println("Simple Interest is ${SI(200,7,2)}")
}

