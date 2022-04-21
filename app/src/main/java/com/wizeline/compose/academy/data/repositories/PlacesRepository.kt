package com.wizeline.compose.academy.data.repositories

import com.wizeline.compose.academy.data.datasources.LocalPlacesDatasource
import com.wizeline.compose.academy.data.models.Place

class PlacesRepository {
    fun fetchPLaces(): List<Place> {
        return LocalPlacesDatasource().fetchPlaces()
    }
    fun fetchPLace(name: String): Place? {
        return LocalPlacesDatasource().fetchPlace(name)
    }
}