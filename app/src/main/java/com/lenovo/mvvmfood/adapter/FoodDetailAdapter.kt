package com.lenovo.mvvmfood.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.lenovo.mvvmfood.R
import com.lenovo.mvvmfood.bean.FoodDetail
import com.lenovo.mvvmfood.databinding.ItemFoodmenuBinding
import com.lenovo.mvvmfood.databinding.ItemFoodtailBinding

class FoodDetailAdapter(
    var context: Context,
    var list: ArrayList<FoodDetail.ResultBean.DataBean>?
) : RecyclerView.Adapter<FoodDetailAdapter.DetailViewHolder>() {

    class DetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val databing = DataBindingUtil.inflate<ItemFoodtailBinding>(
            LayoutInflater.from(context),
            R.layout.item_foodtail, parent, false
        )
        val detailViewHolder = DetailViewHolder(databing.root)
        return detailViewHolder
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val dataBindingUtil = DataBindingUtil.bind<ItemFoodtailBinding>(holder.itemView)

        dataBindingUtil?.let {
            it.foodDetail = (list?.get(position)
                ?: it.executePendingBindings()) as FoodDetail.ResultBean.DataBean?
        }
    }

    override fun getItemCount(): Int {

        Log.i("zyl", "food detail adapter  " + list?.size)
        if (list == null) {
            return 0
        } else {
            return list!!.size
        }


    }
}