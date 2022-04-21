package com.wizeline.compose.academy.domain.models

data class PlaceModel(
    val title: String,
    val address: String,
    val price: String,
    val priceRate: String,
    val rates: Int,
    val rateAverage: Double
)