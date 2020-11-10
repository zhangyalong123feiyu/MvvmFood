package com.lenovo.mvvmfood.bean

import java.io.Serializable

class FoodMenuBean : Serializable {
    var resultcode: String? = null
    var reason: String? = null
    var result: List<Food>? = null

    class Food {
        var parentId: String? = null
        var name: String? = null
        var list: ArrayList<FoodMenuD>? = null

         class FoodMenuD {
            var id: String? = null
            var name: String? = null
            var parentId: String? = null
        }
    }
}