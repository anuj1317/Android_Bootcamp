package com.example.android_bootcamp_anuj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Signup_activity : AppCompatActivity() {
    lateinit var et_userName: EditText
    lateinit var et_userEmail: EditText
    lateinit var et_userPassword:EditText
    lateinit var et_userPhone:EditText
    val MIN_PASSWORD_LENGTH = 6;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // Observing Activity Lifecycle
        Log.i("Activity_Lifecycle", "onCreate")


        //Function for ID's
        viewInitializations()

        val signupButton = findViewById<Button>(R.id.signup_btn)

        //OnClick for SignUp Button
        signupButton.setOnClickListener {
            performSignUp()
        }
    }

    //All fields ID's
    fun viewInitializations() {
        et_userName = findViewById(R.id.username)
        et_userEmail = findViewById(R.id.user_email)
        et_userPhone = findViewById(R.id.user_phone)
        et_userPassword = findViewById(R.id.user_password)
    }

    // Checking if the input in form is valid
    fun validateInput(): Boolean {
        if (et_userName.text.toString().equals("")) {
            et_userName.setError("Please Enter Username")
            return false
        }
        if (et_userEmail.text.toString().equals("")) {
            et_userEmail.setError("Please Enter Email")
            return false
        }
        if (et_userPhone.text.toString().equals("")) {
            et_userPhone.setError("Please Enter Phone Number")
            return false
        }
        if (et_userPassword.text.toString().equals("")) {
            et_userPassword.setError("Please Enter Password")
            return false
        }

        // checking the proper email format
        if (!isEmailValid(et_userEmail.text.toString())) {
            et_userEmail.setError("Please Enter Valid Email")
            return false
        }

        // checking minimum password Length
        if (et_userPassword.text.length < MIN_PASSWORD_LENGTH) {
            et_userPassword.setError("Password Length must be more than " + MIN_PASSWORD_LENGTH + "characters")
            return false
        }


        return true
    }

    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


    //Function for handling signup and sending the data to another activity
    fun performSignUp () {
        if (validateInput()) {

            // Input is valid, here send data to next activity

            val userName = et_userName.text.toString()
            val userEmail = et_userEmail.text.toString()
            val userPhone = et_userPhone.text.toString()
            val userpassword = et_userPassword.text.toString()
            Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show()

             //intent for homescreen
            val intent = Intent(this, MainActivity::class.java)

            //Sending Data
            intent.putExtra("userName", userName)
            intent.putExtra("email", userEmail)
            intent.putExtra("phoneNum", userPhone)
            intent.putExtra("password", userpassword)
            startActivity(intent)


        }
    }

    override fun onStart() {
        super.onStart()
        // Observing Activity Lifecycle
        Log.i("Activity_Lifecycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        // Observing Activity Lifecycle
        Log.i("Activity_Lifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        // Observing Activity Lifecycle
        Log.i("Activity_Lifecycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        // Observing Activity Lifecycle
        Log.i("Activity_Lifecycle", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Activity_Lifecycle", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        // Observing Activity Lifecycle
        Log.i("Activity_Lifecycle", "onDestroy")
    }

}