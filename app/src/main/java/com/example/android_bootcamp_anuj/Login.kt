package com.example.android_bootcamp_anuj

import SharedPrefUtil
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        button_login.setOnClickListener {
            // store value in sharedPreference
            var sharedPreferences: SharedPrefUtil = SharedPrefUtil(this)
            sharedPreferences.putPreference(SharedPrefUtil.KEY_EMAIL, et_useremail.text.toString())
            sharedPreferences.putPreference(SharedPrefUtil.KEY_PASSWORD, et_userpassword.text.toString())
            sharedPreferences.putPreference(SharedPrefUtil.KEY_IS_LOOGGED_IN, true)

            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }
    }


}