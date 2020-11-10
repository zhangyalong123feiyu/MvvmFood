package com.lenovo.mvvmfood.api

import com.lenovo.mvvmfood.bean.FoodMenuBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodApi {

    @GET("category")
    fun getFoodMenu(@Query("key") key:String):Call<FoodMenuBean>

}