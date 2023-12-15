package com.example.pract40

import retrofit2.Call
import retrofit2.http.GET

interface MessageApi {
    @GET("messages1.json")
    fun messages() : Call<MutableList<Message>>
}