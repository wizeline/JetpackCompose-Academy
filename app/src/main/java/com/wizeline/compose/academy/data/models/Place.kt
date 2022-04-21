package com.wizeline.compose.academy.data.models

data class Place(
    val title: String,
    val address: String,
    val price: Double,
    val priceRate: String,
    val rates: Int,
    val rateAverage: Double
)