package com.wizeline.compose.academy.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Section(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("section_name")
    @Expose
    val name: String,
)
