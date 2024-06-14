package com.BitMatrix.gptprompt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.BitMatrix.gptprompt.databinding.ActivityMainBinding
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    //object creation
    private lateinit var binding: ActivityMainBinding

    //    using same function with more functionality
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //assigned a value which is not null
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonSubmit.setOnClickListener {
            // add logic to go to URL and get the Gemini AI output

            val inputPrompt = binding.inputEdit.text.toString()
            //input prompt

            val apiInstance = RetrofitClient.getInstance().create(GPTInterface::class.java)
            apiInstance.getResponse(inputPrompt).enqueue(object:Callback<JsonObject> {
                override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                    binding.outputText.text = response.body().toString()
                }

                override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                    binding.outputText.text = t.toString()
                }

            })
        }
    }
}

