package com.wizeline.compose.academy.ui.models

import androidx.annotation.DrawableRes

data class PlaceItem(
  val name: String = "",
  val address: String = "",
  val price: Double = 0.0,
  @DrawableRes val image: Int = 0,
  val rating: Int = (1..5).random(),
  val reviews: Int = (2..1000).random()
)