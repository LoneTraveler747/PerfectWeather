package com.example.perfectweather.data.Responce


import com.google.gson.annotations.SerializedName

data class Request(
     val type: String,
     val query: String,
     val language: String,
     val unit: String
)