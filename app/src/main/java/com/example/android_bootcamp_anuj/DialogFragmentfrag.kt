package com.example.android_bootcamp_anuj

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class DialogFragmentfrag : DialogFragment() {

    // Get argument using Safe args
    val args: DialogFragmentfragArgs by navArgs()
    lateinit var navController: NavController
    private val TAG = DialogFragmentfragArgs::class.java.simpleName
    lateinit var descriptionEditText: EditText

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        navController = findNavController()
        // Get data using Safe args
        val title = args.dialogFragmentTitle

        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater
        val dialogLayout = inflater.inflate(R.layout.fragment_dialog, null)
        descriptionEditText = dialogLayout.findViewById(R.id.description_ET)

        return builder
            // Inflate and set the layout for the dialog
            .setView(dialogLayout)
            .setTitle(title)
            .setCancelable(false)
            .setPositiveButton("Submit") { dialog, whic ->
                //Log.i(TAG, "Description is ${descriptionEditText.text}")
                getDescriptionFromDialog()
            }
            .create()
    }

    private fun getDescriptionFromDialog() {
        if (!isDescriptionEmpty()) {
            Log.i(TAG, "Description is ${descriptionEditText.text}")
            navController.previousBackStackEntry?.savedStateHandle?.set(
                MainActivity.DESCRIPTION_KEY,
                descriptionEditText.text.toString()
            )

        } else {
            navController.previousBackStackEntry?.savedStateHandle?.set(
                MainActivity.DESCRIPTION_KEY,
               "Entering description is must"
            )
            Toast.makeText(
                context,
                "Entering description is must",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun isDescriptionEmpty(): Boolean {
        return descriptionEditText.text.toString() == ""
    }
}