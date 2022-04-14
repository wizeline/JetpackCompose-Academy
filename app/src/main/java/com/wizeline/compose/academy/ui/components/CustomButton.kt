package com.wizeline.compose.academy.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme
import com.wizeline.compose.academy.ui.theme.PrimaryBlue
import com.wizeline.compose.academy.ui.theme.PrimaryGray

@Composable
fun CustomButton(
    title: String,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_small)),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = PrimaryBlue
        )
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h6.copy(
                color = Color.White
            )
        )
    }
}

@Composable
fun CustomCircleButton(
    icon: ImageVector
) {
    Box(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))) {
        Box(modifier = Modifier
            .background(
                color = Color.White,
                shape = CircleShape
            )
            .padding(dimensionResource(id = R.dimen.padding_small))
        ){
            Icon(
                icon,
                contentDescription = null,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small)),
                tint = PrimaryGray
            )
        }
    }
}



@Composable
@Preview
fun PreviewCustomButton() {
    ComposeAcademyTheme {
        Surface {
            /*
            CustomButton(title = stringResource(id = R.string.label_sign_in),
                modifier = Modifier,
            onClick = {})
             */
            CustomCircleButton(
                icon = Icons.Outlined.FavoriteBorder)
        }
    }
}