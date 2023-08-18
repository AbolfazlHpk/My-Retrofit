package com.example.myapp.data.Remote

import com.example.myapp.utils.Constance
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(Constance.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}
