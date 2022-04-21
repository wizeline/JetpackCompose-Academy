package com.wizeline.compose.academy.data.datasources

import com.wizeline.compose.academy.data.models.Place

class LocalPlacesDatasource {
    val places = listOf(
        Place(
            "Casa Las Tortugas",
            "Av Damero, Mexico",
            1260.0,
            "night",
            347,
            5.0
        ),
        Place(
            "Aonang Villa Resort",
            "Aonang, Thailand",
            2190.0,
            "night",
            231,
            5.0
        )
    )
    fun fetchPlaces(): List<Place> {
        return places
    }

    fun fetchPlace(name: String): Place? {
        return places.find { it.title == name }
    }
}