package com.purplenoise.glossea.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.purplenoise.glossea.ui.theme.CustomTheme

@Composable
fun GreetingSection(name: String) {
    val typography = CustomTheme.typography
    val colors = CustomTheme.colorScheme

    Column {
        Text("Hi, $name", style = typography.body, color = colors.onPrimary)
        Text("Semangat belajarnya !", style = typography.labelLarge, color = colors.onPrimary)
    }
}
