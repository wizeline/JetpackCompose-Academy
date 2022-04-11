package com.wizeline.compose.academy.domain

import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.data.models.Category
import com.wizeline.compose.academy.data.models.Place

class DataGenerator {
    companion object {
        val categoryList = listOf(
            Category(title = "Mountains", image = R.drawable.mountains),
            Category(title = "Beach", image = R.drawable.beach),
            Category(title = "Forest", image = R.drawable.forest)
        )

        val placeList = listOf(
            Place(
                name = "Casa Las Tortugas",
                location = "Av. Damero, Mexico",
                address = "Av. Damero 77310 Isla Holbox, Q.R, Mexico",
                ranking = 5,
                reviews = 345,
                price = 1260.00,
                image = R.drawable.hotel_image
            ),
            Place(
                name = "Aonang",
                location = "Aonang, Thailand",
                address = "Av. Anongang 4567, Thailand, T.R",
                ranking = 4,
                reviews = 765,
                price = 2450.00,
                image = R.drawable.hotel_image_2
            )
        )

        val getPlace = placeList.random()

        val imageGalleryList = listOf(
            R.drawable.hotel_gallery,
            R.drawable.hotel_gallery_2,
            R.drawable.hotel_gallery_3
        )
    }
}
