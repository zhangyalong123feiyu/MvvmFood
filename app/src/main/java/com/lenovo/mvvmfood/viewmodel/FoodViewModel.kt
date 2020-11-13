package com.lenovo.mvvmfood.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lenovo.mvvmfood.bean.FoodDetail
import com.lenovo.mvvmfood.bean.FoodMenuBean
import com.lenovo.mvvmfood.model.FoodMenuModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodViewModel : ViewModel() {

    val foodModel = FoodMenuModel()
    val foodLiveData = MutableLiveData<FoodMenuBean>()
    var foodDetailLiveData = MutableLiveData<ArrayList<FoodDetail.ResultBean.DataBean>>()

    fun getFoodData(key: String): LiveData<FoodMenuBean> {
        getFoodMenu(key)
        return foodLiveData
    }

    fun getFoodDetailLiveData(cid: String, key: String): LiveData<ArrayList<FoodDetail.ResultBean.DataBean>> {

        getFoodDetail(cid, key)

        return foodDetailLiveData

    }

    private fun getFoodMenu(key: String) {
        foodModel.getFoodMenu(key, object : Callback<FoodMenuBean> {
            override fun onResponse(
                call: Call<FoodMenuBean>,
                response: Response<FoodMenuBean>
            ) {

                var foodData = response.body()
                Log.i("zyl", foodData?.result?.get(0)?.list?.get(1)?.name + "====foodData name")
                foodLiveData.value = foodData
            }

            override fun onFailure(call: Call<FoodMenuBean>, t: Throwable) {
                Log.i("zyl", "error========" + t.message)
            }
        })
    }

    private fun getFoodDetail(cid: String, key: String) {
        foodModel.getFoodDetail(cid, key, object : Callback<FoodDetail> {
            override fun onResponse(
                call: Call<FoodDetail>,
                response: Response<FoodDetail>
            ) {

                var foodData = response.body()
                Log.i(
                    "zyl",
                    foodData?.result?.data?.get(0)?.albums?.get(0) !!+"  ===detail foodData name"
                )

                foodDetailLiveData.value = foodData.result!!.data
                Log.i("zyl","viewModel foodDetail live data size"+foodDetailLiveData.value?.size)
            }

            override fun onFailure(call: Call<FoodDetail>, t: Throwable) {
                Log.i("zyl", "error========" + t.message)
            }
        })
    }
}