package com.lenovo.mvvmfood

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.lenovo.mvvmfood.bean.FoodDetail
import com.lenovo.mvvmfood.databinding.ActivityDetailBinding
import com.lenovo.mvvmfood.viewmodel.FoodViewModel

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBind =
            DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail)

        val viewmodel = ViewModelProvider(this)[FoodViewModel::class.java]

        viewmodel.getFoodDetailLiveData("1", "584be421b1413d5eb0340d422d5b0d53").observe(this,
            {
                dataBind.foodDetail = viewmodel.foodDetailLiveData.value
                dataBind.foodMenuRecy.adapter?.notifyDataSetChanged()
            })

    }
}