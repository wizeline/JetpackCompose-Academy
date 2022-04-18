package com.wizeline.compose.academy.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Place(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("place_name")
    @Expose
    val name: String,
    @SerializedName("place_address")
    @Expose
    val address: String,
    @SerializedName("place_image")
    @Expose
    val imageUrl: String,
    @SerializedName("place_rank")
    @Expose
    val rank: Int,
    @SerializedName("place_price")
    @Expose
    val price: String,
    @SerializedName("place_information")
    @Expose
    val information: List<Section>,
    @SerializedName("gallery_images")
    @Expose
    val images: List<GalleryImage>,
)
