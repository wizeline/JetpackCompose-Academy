package com.wizeline.compose.academy.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("id_model")
    @Expose
    val id: Int,
    @SerializedName("category_name")
    @Expose
    val name: String,
    @SerializedName("category_image")
    @Expose
    val imageUrl: String,
)
