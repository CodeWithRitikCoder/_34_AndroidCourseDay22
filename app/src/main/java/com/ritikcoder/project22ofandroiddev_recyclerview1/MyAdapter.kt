package com.ritikcoder.project22ofandroiddev_recyclerview1

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(var newsArrayList: ArrayList<News>, var context: Activity) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    //Here I am creating own Interface.
    private lateinit var myListener: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    //Creation of a own function here.
    fun setOnItemClickListener(listener: onItemClickListener){
        //initialization of myListener variable
        myListener= listener
    }

    //to create new view instance.
    //when layout manager fails to find a suitable view for each item.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.each_row, parent, false)
        return MyViewHolder(itemView, myListener)
    }

    //It holds the view so views are not created everytime, so memory can be saved.
    class MyViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val headingTitle: TextView = itemView.findViewById<TextView>(R.id.textViewForForHeadingTitle)
        val headingImage: ShapeableImageView = itemView.findViewById<ShapeableImageView>(R.id.shapeableImageView)
        val nameHeading: TextView= itemView.findViewById(R.id.textViewForPersonName)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    //Populate items with data.
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        var currentItem= newsArrayList[position]
        holder.headingTitle.text= currentItem.newsHeading
        holder.headingImage.setImageResource(currentItem.newsImage)
        holder.nameHeading.text= (currentItem.personName)
    }

    //How many list items are present in your array.
    override fun getItemCount(): Int {
        return newsArrayList.size
    }

}