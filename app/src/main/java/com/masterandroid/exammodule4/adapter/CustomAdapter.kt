package com.masterandroid.exammodule4.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.masterandroid.exammodule4.R
import com.masterandroid.exammodule4.listener.OnBottomReachedListener
import com.masterandroid.exammodule4.model.Meal

class CustomAdapter(var context: Context,var meals:List<Meal>,
                    var listener: OnBottomReachedListener? = null): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_meals,parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == meals.size - 1) {
            listener!!.OnBottomReached(position)
        }
        val meal = meals[position]

        if (holder is CustomViewHolder){
            holder.image.setImageResource(meal.image)
            holder.nameMeal.setText(meal.nameMeal)
            holder.rating.stepSize
            holder.nameRes.setText(meal.nameRes)
        }
    }

    override fun getItemCount(): Int {
        return meals.size
    }
    class CustomViewHolder( view: View) : RecyclerView.ViewHolder(view){
        var image:ImageView = view.findViewById(R.id.image)
        var nameMeal: TextView = view.findViewById(R.id.tv_name_of_meal)
        var rating:RatingBar = view.findViewById(R.id.rating)
        var  nameRes: TextView = view.findViewById(R.id.tv_name_of_restourant)


    }
}