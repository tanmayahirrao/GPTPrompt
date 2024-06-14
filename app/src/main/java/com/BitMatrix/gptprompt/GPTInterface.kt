package com.BitMatrix.gptprompt

import android.text.Editable
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GPTInterface {    // a popular HTTP client library for Android and Java, to interact with a web API

    // tood make GET parameter an END_POINT
    @GET("api/genai/{prompt}")
    fun getResponse(@Path("prompt") question: String): Call<JsonObject>
}