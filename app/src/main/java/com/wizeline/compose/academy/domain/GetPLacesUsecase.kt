package com.wizeline.compose.academy.domain

import com.wizeline.compose.academy.data.repositories.PlacesRepository
import com.wizeline.compose.academy.domain.mappers.toPlaceModelList
import com.wizeline.compose.academy.domain.models.PlaceModel

class GetPLacesUsecase {
    fun fetchPlaces(): List<PlaceModel> {
        return PlacesRepository().fetchPLaces().toPlaceModelList()
    }
}