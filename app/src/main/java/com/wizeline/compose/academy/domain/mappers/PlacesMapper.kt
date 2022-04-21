package com.wizeline.compose.academy.domain.mappers

import com.wizeline.compose.academy.data.models.Place
import com.wizeline.compose.academy.domain.getFormatMoney
import com.wizeline.compose.academy.domain.models.PlaceModel

fun Place.toPLaceModel(): PlaceModel =
    PlaceModel(title, address, "\$${price.getFormatMoney()}",priceRate, rates, rateAverage)

fun List<Place>.toPlaceModelList(): List<PlaceModel> =
    this.map { place -> place.toPLaceModel() }