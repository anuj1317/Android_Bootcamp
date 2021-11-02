package com.example.android_bootcamp_anuj.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_bootcamp_anuj.Model.Model
import com.example.android_bootcamp_anuj.R


class CustomAdapter() : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    var dataList = mutableListOf<Model>()

    //Setting Data
    fun setData(data: List<Model>) {
        this.dataList = data.toMutableList()
        notifyDataSetChanged()
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val postTitleTextView: TextView = view.findViewById(R.id.postTitle_TV)
        val postBodyTextView: TextView = view.findViewById(R.id.post_Msg_TV)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = dataList.size

    // Replace the contents of a view (invoked by the layout manager)
    // Used to replace/update views at a specific position
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.postTitleTextView.text = dataList[position].postTitle
        holder.postBodyTextView.text = dataList[position].postBody
    }
}