package com.wizeline.compose.academy.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FullModel(
    @SerializedName("id_model")
    @Expose
    val id: Int,
    @SerializedName("sections")
    @Expose
    val sections: List<Section>,
    @SerializedName("places")
    @Expose
    val places: List<Place>,
    @SerializedName("categories")
    @Expose
    val categories: List<Category>,
)
