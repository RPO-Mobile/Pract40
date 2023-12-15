package com.example.pract40

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pract40.databinding.MainActBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Main : AppCompatActivity() {
    lateinit var mainAct : MainActBinding
    val retrofit = Retrofit.Builder()
        .baseUrl("https://rawgit.com/startandroid/data/master/messages/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainAct = MainActBinding.inflate(layoutInflater)
        setContentView(mainAct.root)
    }
}