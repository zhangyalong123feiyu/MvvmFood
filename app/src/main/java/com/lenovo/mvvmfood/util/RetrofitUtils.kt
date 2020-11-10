package com.lenovo.mvvmfood.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitUtils {

    companion object {                         //相当于Java中的静态方法
        private var retrofit: Retrofit ?=null

        fun getRetrofit(): Retrofit {

            if (retrofit == null) {
                synchronized(RetrofitUtils::class.java) {
                    if (retrofit == null) {
                        retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("http://apis.juhe.cn/cook/").build()
                    }
                }
            }
            return retrofit!!

        }

        fun <T> createRequest(clas: Class<T>): T {
            var clas = getRetrofit()!!.create(clas)
            return clas
        }
    }

}