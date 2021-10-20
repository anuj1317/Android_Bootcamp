package com.example.android_bootcamp_anuj

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.android_bootcamp_anuj.model.DataItem
import com.example.android_bootcamp_anuj.retrofit.RetrofitInstance
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var progressDialog: ProgressDialog
    val TAG = "Anuj"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createProgressDialog()

        getDetailsBtn.setOnClickListener {
            val getIdToFetch = edittext_id.text
           Log.i(TAG,"$getIdToFetch")

            if (getIdToFetch.isNullOrEmpty() || getIdToFetch.toString().toInt() > 10 || getIdToFetch.toString().toInt() < 1
            ) {
                edittext_id.setError("Enter digit between 1 to 10")
            } else {
                progressDialog.show()
                getMyData(getIdToFetch.toString().toInt())
            }


        }




    }

    private fun createProgressDialog() {
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading")
        progressDialog.setMessage("Please Wait...")
        progressDialog.setCancelable(false)
    }

    private fun getMyData(id:Int) {


        val retrofitData = RetrofitInstance.retrofitBuilder.getData(id)
        //Ctrl+shift+space to get the callbacks
        retrofitData.enqueue(object : Callback<List<DataItem>?> {
            override fun onResponse(
                call: Call<List<DataItem>?>,
                response: Response<List<DataItem>?>
            ) {
                progressDialog.dismiss()
                Log.i("MainActivity", "Data is ${response.body()}")
                for (data in response.body()!!) {
                    //println("Data is ${data.postID}, ${data.postTitle}, ${data.postBody}")
                    textview_id.text = "Post Id: ${data.id.toString()}"
                    textview_title.text = "Title: ${data.title}"
                    textview_body.text = "Body: ${data.body}"
                }
            }

            override fun onFailure(call: Call<List<DataItem>?>, t: Throwable) {
              Log.d("MainActivity","onFailure:" + t.message)
            }
        })

    }
}