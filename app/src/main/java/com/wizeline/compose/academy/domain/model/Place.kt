package com.wizeline.compose.academy.domain.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.wizeline.compose.academy.R

data class Place(
    var id: Int,
    var ranking: Int,
    var name: String,
    var location: String,
    var price: String,
    var imageId: Int,
    var imagesList: List<PlacePictures>,
    var reviews: Int,
    var description: String
)

@Composable
fun getPlaces(): List<Place> {

    val context = LocalContext.current

    return listOf(
        Place(
            id =1,
            reviews = 347,
            ranking = 4,
            name = context.getString(R.string.label_las_tortugas),
            location = context.getString(R.string.label_damero),
            price = context.getString(R.string.label_tortuga_price),
            imageId = context.resources.getIdentifier(
                "hotel_image",
                "drawable",
                context.packageName
            ),
            imagesList = listOf(
                PlacePictures(
                    context.resources.getIdentifier(
                        "hotel_gallery",
                        "drawable",
                        context.packageName
                    )
                ),
                PlacePictures(
                    context.resources.getIdentifier(
                        "hotel_gallery_2",
                        "drawable",
                        context.packageName
                    )
                ),
                PlacePictures(
                    context.resources.getIdentifier(
                        "hotel_gallery_3",
                        "drawable",
                        context.packageName
                    )
                )
            ),
        description= context.getString(R.string.tortuga_description)
        ),
        Place(
            id =2,
            reviews = 1943,
            ranking = 3,
            name = context.getString(R.string.label_isla_bonita),
            location = context.getString(R.string.label_isla_bonita_location),
            price = context.getString(R.string.label_isla_bonita_price),
            imageId = context.resources.getIdentifier(
                "hotel_image_1",
                "drawable",
                context.packageName
            ),
            imagesList = listOf(
                PlacePictures(
                    context.resources.getIdentifier(
                        "hotel_gallery_2",
                        "drawable",
                        context.packageName
                    )
                ),
                PlacePictures(
                    context.resources.getIdentifier(
                        "hotel_gallery",
                        "drawable",
                        context.packageName
                    )
                ),
                PlacePictures(
                    context.resources.getIdentifier(
                        "hotel_gallery_3",
                        "drawable",
                        context.packageName
                    )
                )
            ),
            description = context.getString(R.string.isla_description)
        ),
        Place(
            id =3,
            reviews = 980,
            ranking = 5,
            name = context.getString(R.string.label_casa_caribe),
            location = context.getString(R.string.label_casa_caribe_location),
            price = context.getString(R.string.label_casa_caribe_price),
            imageId = context.resources.getIdentifier(
                "hotel_image_2",
                "drawable",
                context.packageName
            ),
            imagesList = listOf(
                PlacePictures(
                    context.resources.getIdentifier(
                        "hotel_gallery_3",
                        "drawable",
                        context.packageName
                    )
                ),
                PlacePictures(
                    context.resources.getIdentifier(
                        "hotel_gallery",
                        "drawable",
                        context.packageName
                    )
                ),
                PlacePictures(
                    context.resources.getIdentifier(
                        "hotel_gallery_2",
                        "drawable",
                        context.packageName
                    )
                )
            ),
            description = context.getString(R.string.caribe_description)
        )
    )
}