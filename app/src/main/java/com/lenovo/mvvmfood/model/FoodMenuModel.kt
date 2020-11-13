package com.lenovo.mvvmfood.model

import com.lenovo.mvvmfood.api.FoodApi
import com.lenovo.mvvmfood.bean.FoodDetail
import com.lenovo.mvvmfood.bean.FoodMenuBean
import com.lenovo.mvvmfood.util.RetrofitUtils
import retrofit2.Callback

class FoodMenuModel {

    fun getFoodMenu(key:String,callback: Callback<FoodMenuBean>){
        var foodApi=RetrofitUtils.getRetrofit().create(FoodApi::class.java)
        foodApi.getFoodMenu(key).enqueue(callback)
    }

    fun getFoodDetail(cid:String,key:String,callback: Callback<FoodDetail>){
        var foodApi=RetrofitUtils.getRetrofit().create(FoodApi::class.java)
        foodApi.getFoodDetail(cid,key).enqueue(callback)
    }

}