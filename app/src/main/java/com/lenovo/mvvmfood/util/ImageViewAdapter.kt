package com.lenovo.mvvmfood.util

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lenovo.mvvmfood.R
import com.lenovo.mvvmfood.adapter.FoodDetailAdapter
import com.lenovo.mvvmfood.bean.FoodDetail


object ImageViewAdapter {
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String) {
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView)
    }

    @BindingAdapter("bindRecyleData")
    @JvmStatic
    fun setRecyleData(recyclerView: RecyclerView,data:ArrayList<FoodDetail.ResultBean.DataBean>?){
        Log.i("zyl","imagebinder == data size == "+data?.size)
        recyclerView.adapter=FoodDetailAdapter(recyclerView.context,data)
    }

}