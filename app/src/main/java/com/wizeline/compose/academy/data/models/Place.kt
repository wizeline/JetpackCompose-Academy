package com.wizeline.compose.academy.data.models

data class Place(
    val name: String,
    val location: String,
    val address: String,
    val reviews: Int,
    val ranking: Int,
    val price: Double,
    val image: Int
)
