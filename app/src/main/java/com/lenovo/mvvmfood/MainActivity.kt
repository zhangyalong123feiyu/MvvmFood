package com.lenovo.mvvmfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lenovo.mvvmfood.adapter.FoodAdapter
import com.lenovo.mvvmfood.bean.FoodMenuBean
import com.lenovo.mvvmfood.databinding.ActivityMainBinding
import com.lenovo.mvvmfood.viewmodel.FoodViewModel

class MainActivity : AppCompatActivity() {

    var dataList = ArrayList<FoodMenuBean.Food.FoodMenuD>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBind =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val foodViewModel = ViewModelProvider(this)[FoodViewModel::class.java]

        val foodAdapter =
            FoodAdapter(dataList, this)

        dataBind.foodMenuRecy.adapter = foodAdapter

        foodViewModel.getFoodData("584be421b1413d5eb0340d422d5b0d53").observe(this,
            {
                dataList.addAll(foodViewModel.foodLiveData.value?.result?.get(0)?.list!!)
                foodAdapter.notifyDataSetChanged()
            })

    }
}