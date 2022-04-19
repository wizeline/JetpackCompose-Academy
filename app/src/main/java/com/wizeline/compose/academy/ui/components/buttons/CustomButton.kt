package com.wizeline.compose.academy.ui.components.buttons

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.wizeline.compose.academy.R
import com.wizeline.compose.academy.tools.dp_5
import com.wizeline.compose.academy.tools.dp_8
import com.wizeline.compose.academy.ui.theme.ComposeAcademyTheme

@Composable
fun CustomButton(
    title: String,
    modifier: Modifier = Modifier,
    click: (() -> Unit)? = null,
) {
    Button(
        onClick = { click?.invoke() },
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.padding(dp_5),
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(dp_8),
            fontWeight = FontWeight.Bold,
        )
    }
}

@Preview
@Composable
private fun CustomButtonPreview() {
    ComposeAcademyTheme {
        Surface {
            CustomButton(
                stringResource(id = R.string.label_sign_in),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun CustomButtonDarkPreview() {
    CustomButtonPreview()
}
