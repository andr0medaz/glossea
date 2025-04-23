package com.purplenoise.glossea.ui.component.atom


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.purplenoise.glossea.ui.component.BottomBar
import com.purplenoise.glossea.ui.screen.OnboardingScreen
import com.purplenoise.glossea.ui.theme.CustomTheme
import kotlinx.coroutines.delay



@Composable
fun CenteredAutoResetButton(
    modifier: Modifier = Modifier,
    resetDelayMillis: Long = 2000L
) {
    val colors = CustomTheme.colorScheme
    val typography = CustomTheme.typography
    val shapes = CustomTheme.shape

    var isClicked by remember { mutableStateOf(false) }

    if (isClicked) {
        LaunchedEffect(Unit) {
            delay(resetDelayMillis)
            isClicked = false
        }
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { isClicked = true },
            modifier = Modifier.height(48.dp),
            shape = shapes.button,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isClicked) colors.secondary else colors.primary
            )
        ) {
            Text(
                text = if (isClicked) "Clicked!" else "Next",
                color = colors.onPrimary,
                style = typography.labelLarge
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    CustomTheme {
        CenteredAutoResetButton()
    }
}
