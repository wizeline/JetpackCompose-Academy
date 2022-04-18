package com.wizeline.compose.academy.ui.models

import androidx.annotation.DrawableRes

data class CategoriesItem(
  val name: String = "",
  @DrawableRes val image: Int = 0
)