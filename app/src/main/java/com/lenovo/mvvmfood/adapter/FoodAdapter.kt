package com.lenovo.mvvmfood.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.lenovo.mvvmfood.DetailActivity
import com.lenovo.mvvmfood.R
import com.lenovo.mvvmfood.bean.FoodMenuBean
import com.lenovo.mvvmfood.databinding.ItemFoodmenuBinding

class FoodAdapter(var foodMenuD: ArrayList<FoodMenuBean.Food.FoodMenuD>,var context:Context) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        var databing=DataBindingUtil.inflate<ItemFoodmenuBinding>(LayoutInflater.from(context),R.layout.item_foodmenu,parent,false)
        var foodViewHolder=FoodViewHolder(databing.root)
        return foodViewHolder
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        var dataBindingUtil=DataBindingUtil.bind<ItemFoodmenuBinding>(holder.itemView)

        dataBindingUtil?.let {
            it.foodData=foodMenuD[position]
            it.executePendingBindings()
            it.foodName.setOnClickListener {
                context.startActivity(Intent(context,DetailActivity::class.java))
            }
        }
    }

    override fun getItemCount(): Int {
        Log.i("zyl","foodsize"+foodMenuD.size)
        return foodMenuD.size
    }
}