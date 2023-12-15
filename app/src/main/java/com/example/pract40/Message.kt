package com.example.pract40

import java.io.Serializable

data class Message (
    val id : Long,
    val time : Long,
    val text : String,
) : Serializable