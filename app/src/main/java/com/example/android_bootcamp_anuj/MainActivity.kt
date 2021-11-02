package com.example.android_bootcamp_anuj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_bootcamp_anuj.adapter.CustomAdapter
import com.example.android_bootcamp_anuj.viewModel.MainViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var mUserMainViewModel: MainViewModel
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerView: RecyclerView
    var lastItem:Int?=null
    val tag = "Anuj"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // getting the recyclerview by its id
        recyclerView = findViewById<RecyclerView>(R.id.recyclerview)

        linearLayoutManager = LinearLayoutManager(this)

        // this creates a vertical layout Manager
        recyclerView.layoutManager = linearLayoutManager
//
////         ArrayList of class ItemsViewModel
//        val data = ArrayList<Items>()
//
//        // This loop will create 20 Views containing
//        // the image with the count of view
//        for (i in 1..100) {
//            data.add(Items(R.drawable.ic_launcher_foreground, "Item " + i))
//        }

//       val receivePosition:Int = getPosition()
//        Log.e(tag,"$receivePosition")
        mUserMainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mUserMainViewModel.fetch()
//
//        // This will pass the ArrayList to our Adapter
//        val adapter = CustomAdapter(mUserViewModel.data)
        val adapter = CustomAdapter(mUserMainViewModel.data)
        // Setting the Adapter with the recyclerview

        val ab = getItem()
        Log.e(tag,"onCreate$ab")

        ab?.let { (recyclerView.layoutManager as LinearLayoutManager).scrollToPosition(it) }

        recyclerView.adapter = adapter


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_item, menu)
        return true
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.item){
            val intent = Intent(this, ViewActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onPause(){
        super.onPause()
        val item = getItem()
        Log.e(tag,"onPause$item")

    }

    private fun getItem(): Int? {
        lastItem = linearLayoutManager.findFirstCompletelyVisibleItemPosition()
//        Log.e(tag,"onPause$lastItem")
        return lastItem
    }


//    override fun onResume() {
//        super.onResume()
//        val ab = getItem()
//      // recyclerView.layoutManager?.scrollToPosition(lastItem)
//        Log.e(tag,"onResume$ab")
//       ab?.let { (recyclerView.layoutManager as LinearLayoutManager).scrollToPosition(it) }
//    }
}