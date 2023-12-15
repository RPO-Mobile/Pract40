package com.example.pract40

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.pract40.databinding.MainActBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Main : AppCompatActivity() {
    lateinit var mainAct : MainActBinding
    val messageApi = Retrofit.Builder()
        .baseUrl("https://rawgit.com/startandroid/data/master/messages/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MessageApi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainAct = MainActBinding.inflate(layoutInflater)
        setContentView(mainAct.root)
        getMessages()

        mainAct.lv.setOnItemClickListener{ _, _, i, _ ->
            val intent = Intent(this, Second::class.java)
            intent.putExtra("Message", mainAct.lv.adapter.getItem(i) as Message)
            secondActLauncher.launch(intent)
        }
    }

    fun getMessages(){
        val messages = messageApi.messages()
        var messagesList = mutableListOf<Message>()
        messages.enqueue(object : Callback<MutableList<Message>>{
            override fun onResponse(call: Call<MutableList<Message>>, response: Response<MutableList<Message>>) {
                if (response.body() != null)
                    mainAct.lv.adapter = ListAdapter(response.body()!!)
            }
            override fun onFailure(call: Call<MutableList<Message>>, t: Throwable) {
                Log.d("Fail", "onFailure Сработал")
            }
        })
    }

    private val secondActLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){}
}