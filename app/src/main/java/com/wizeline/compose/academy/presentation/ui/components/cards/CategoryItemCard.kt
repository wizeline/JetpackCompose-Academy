package com.wizeline.compose.academy.presentation.ui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.domain.model.Category
import com.wizeline.compose.academy.domain.model.getCategories
import com.wizeline.compose.academy.domain.model.getPlaces
import com.wizeline.compose.academy.presentation.ui.DetailCardContent
import com.wizeline.compose.academy.presentation.ui.components.spacer.CustomWidthSpacer
import com.wizeline.compose.academy.presentation.ui.components.spacer.SpacerWidth
import com.wizeline.compose.academy.presentation.ui.theme.ComposeAcademyTheme

@Composable
fun CategoryItemCard(category : Category){
     Card(shape = MaterialTheme.shapes.small,
          modifier = Modifier
              .background(
                  color = Color.White
              )
              .padding(dimensionResource(id = R.dimen.five)),
          elevation = dimensionResource(id = R.dimen.zero)) {

         Row(verticalAlignment = Alignment.CenterVertically,
             modifier = Modifier.padding(dimensionResource(id = R.dimen.ten))){

             Image(painter = painterResource(id = category.imageId),
                  contentDescription = stringResource(id = R.string.label_category),
                  modifier= Modifier
                      .padding(horizontal = dimensionResource(id = R.dimen.fifteen))
                      .size(dimensionResource(id = R.dimen.fifty))
                      .clip(shape = RoundedCornerShape(corner = CornerSize(dimensionResource(id = R.dimen.twelve)))),
                  contentScale = ContentScale.Crop)

            CustomWidthSpacer(SpacerWidth.EXTRA_SMALL)

             Text(text =  category.name)
         }
     }
}

@Preview
@Composable
fun PreviewCategoryItemCard(){
    ComposeAcademyTheme {
        Surface {
            CategoryItemCard(getCategories()[0])
        }
    }
}
