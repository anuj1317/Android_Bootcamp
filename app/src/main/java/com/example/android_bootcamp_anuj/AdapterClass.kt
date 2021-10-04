package com.example.android_bootcamp_anuj

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.recyclerview.widget.RecyclerView

class AdapterClass(val datavalues: ArrayList<Dataclass>): RecyclerView.Adapter<AdapterClass.ViewHolder>() {

   inner class ViewHolder (itemView:View) : RecyclerView.ViewHolder(itemView){

       val titleView: TextView
       val addressView: TextView
       val imageView: ImageView
       val ratingBar: RatingBar
       val noOfReviews: TextView
       val dateTextView: TextView
       val amountTextView: TextView

       // attach reference of views
       init {
           titleView = itemView.findViewById(R.id.titleView1)
           addressView = itemView.findViewById(R.id.subtitleView1)
           imageView = itemView.findViewById(R.id.imageView1)
           ratingBar = itemView.findViewById(R.id.ratingBar1)
           noOfReviews = itemView.findViewById(R.id.numOfReviews)
           dateTextView = itemView.findViewById(R.id.dateTextView)
           amountTextView = itemView.findViewById(R.id.amountTextView)
       }




   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {
       return datavalues.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleView.text = datavalues[position].title
        holder.addressView.text = datavalues[position].address
        holder.imageView.setImageResource(datavalues[position].imageID)
        holder.ratingBar.numStars = datavalues[position].StarRatings
        holder.noOfReviews.text = datavalues[position].noOfReview
        holder.dateTextView.text = datavalues[position].date
        holder.amountTextView.text = datavalues[position].amount


    }

}