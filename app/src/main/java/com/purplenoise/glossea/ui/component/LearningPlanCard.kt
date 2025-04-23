package com.purplenoise.glossea.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.purplenoise.glossea.ui.theme.CustomTheme

@Composable
fun LearningPlanCard(
    @DrawableRes image: Int,
    title: String,
    description: String,
    onClick: () -> Unit
) {
    val colors = CustomTheme.colorScheme
    val typography = CustomTheme.typography

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colors.secondary.copy(alpha = 0.1f), shape = CustomTheme.shape.container)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .size(72.dp)
                .clip(CustomTheme.shape.container),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(title, style = typography.labelLarge, color = colors.onBackground)
            Text(description, style = typography.labelNormal, color = colors.onBackground)
        }

        Spacer(modifier = Modifier.width(8.dp))

        Button(
            onClick = onClick, shape = CustomTheme.shape.button) {
            Text("Start Now", style = typography.labelSmall)
        }
    }
}
