package com.BitMatrix.gptprompt

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {     // a popular HTTP client library for Android and Java, to interact with a web API

    //val BASE_URL = "http://127.0.0.1:5000"
    val BASE_URL = "http://10.0.2.2:5000"

    val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    fun getInstance(): Retrofit {
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit
    }

    /*    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

object ApiClient {
    val apiService: GPTInterface by lazy {
        RetrofitClient.retrofit.create(GPTInterface::class.java)
    }*/
}

/*
    var retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .build()
}*/
