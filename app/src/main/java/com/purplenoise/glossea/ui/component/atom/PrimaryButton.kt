package com.purplenoise.glossea.ui.component.atom

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.purplenoise.glossea.ui.theme.CustomTheme


@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = CustomTheme.colorScheme.primary,
    contentColor: Color = CustomTheme.colorScheme.onPrimary
//    backgroundColor: Color = MaterialTheme.colorScheme.primary,
) {
    Button(
        onClick = onClick, // ← hanya "hook" interaksi, bukan logika
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ){
        Text(
            text = text,
            style = CustomTheme.typography.labelLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    CustomTheme {
        PrimaryButton(
            text = "Next",
            onClick = {}
        )
    }
}