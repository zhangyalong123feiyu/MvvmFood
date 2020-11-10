package com.lenovo.mvvmfood.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lenovo.mvvmfood.bean.FoodMenuBean
import com.lenovo.mvvmfood.model.FoodMenuModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodViewModel : ViewModel() {

    val foodModel = FoodMenuModel()
    val foodLiveData = MutableLiveData<FoodMenuBean>()

    fun getFoodData(key: String): LiveData<FoodMenuBean> {
        getFoodMenu(key)
        return foodLiveData
    }

    private fun getFoodMenu(key: String) {
        foodModel.getFoodMenu(key, object : Callback<FoodMenuBean> {
            override fun onResponse(
                call: Call<FoodMenuBean>,
                response: Response<FoodMenuBean>
            ) {

                var foodData = response.body()
                Log.i("zyl", foodData?.result?.get(0)?.list?.get(1)?.name + "foodData name")
                foodLiveData.value = foodData
            }

            override fun onFailure(call: Call<FoodMenuBean>, t: Throwable) {
                Log.i("zyl", "error========" + t.message)
            }
        })
    }
}