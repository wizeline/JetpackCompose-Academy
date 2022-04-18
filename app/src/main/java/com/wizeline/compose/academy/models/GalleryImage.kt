package com.wizeline.compose.academy.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GalleryImage(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("url")
    @Expose
    val imageUrl: String,
)
