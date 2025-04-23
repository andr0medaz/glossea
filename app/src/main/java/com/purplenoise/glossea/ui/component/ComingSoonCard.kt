package com.purplenoise.glossea.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.purplenoise.glossea.ui.theme.CustomTheme

@Composable
fun ComingSoonCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray.copy(alpha = 0.5f), shape = CustomTheme.shape.container)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "Listening & Speaking Coming Soon",
            style = CustomTheme.typography.labelLarge,
            color = CustomTheme.colorScheme.onBackground
        )
    }
}
