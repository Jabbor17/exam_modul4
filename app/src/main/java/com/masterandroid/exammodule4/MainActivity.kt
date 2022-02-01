package com.masterandroid.exammodule4

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.masterandroid.exammodule4.adapter.CustomAdapter
import com.masterandroid.exammodule4.listener.OnBottomReachedListener
import com.masterandroid.exammodule4.model.Meal


class MainActivity : AppCompatActivity() {
    lateinit var recyclerView:RecyclerView
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()



    }

    private fun initViews() {
        context = this
        recyclerView = findViewById(R.id.recyclerView)
        if (isTablet(context)) {
            recyclerView.layoutManager = GridLayoutManager(context, 3)
        }else{
            recyclerView.layoutManager = GridLayoutManager(context, 1)

        }

        val meals:ArrayList<Meal> = ArrayList()
        prepareMealList(meals)
        refreshAdapter(meals)
    }

    private fun prepareMealList(meals: ArrayList<Meal>) {
        for (i in 0..10){
            meals.add(Meal(R.drawable.im_meals1,"Meal  "+i,5,"Bon!"))
            meals.add(Meal(R.drawable.im_meals2,"Meal  "+i,4,"Bon!"))
            meals.add(Meal(R.drawable.im_meals3,"Meal  "+i,4,"Bon!"))
            meals.add(Meal(R.drawable.im_meals4,"Meal  "+i,3,"Bon!"))

        }

    }

    fun refreshAdapter(meals: List<Meal>){
        val adapter =CustomAdapter(context,meals, OnBottomReachedListener(){
            fun OnBottomReachedListener(position: Int){
            Log.d("@@@", "@@@position$position")
            }
        })
        recyclerView.adapter = adapter
    }

    fun isTablet(context: Context): Boolean {
        return ((context.resources.configuration.screenLayout
                and Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE)
    }
}