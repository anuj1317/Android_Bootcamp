package com.example.android_bootcamp_anuj

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_splash.view.*

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val  view  =  inflater.inflate(R.layout.fragment_splash, container, false)

        view.splashNext_BTN.setOnClickListener {
            login()
        }

        return view
    }

    private fun login() {
        if (isUserLoggedIn())
            navigateToHome()
        else {
            navigateToLogin()
        }

    }

    private fun navigateToLogin() {
        findNavController().navigate(R.id.action_global_loginFragment)
    }

    private fun navigateToHome() {
        val action =
            SplashFragmentDirections.actionSplashFragmentToHomeFragment()
        findNavController().navigate(action)
    }

    private fun isUserLoggedIn(): Boolean {
        val sharedPreferences = activity?.getSharedPreferences(MainActivity.MY_PREFERENCES, Context.MODE_PRIVATE)
        val name = sharedPreferences?.getString(MainActivity.NAME_KEY, "")
        return name != ""
    }

}