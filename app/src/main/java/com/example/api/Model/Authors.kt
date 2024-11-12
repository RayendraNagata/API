package com.example.api.Model

import com.google.gson.annotations.SerializedName

data class Authors(


    @SerializedName("id")
    val id: Int,
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val fullname: String,
    @SerializedName("avatar")
    val avatar: String
)
