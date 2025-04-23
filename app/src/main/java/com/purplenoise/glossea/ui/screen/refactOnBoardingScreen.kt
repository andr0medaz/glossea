package com.purplenoise.glossea.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.purplenoise.glossea.R
import com.purplenoise.glossea.ui.theme.CustomTheme

@Composable
fun OnboardingScreenScaffold(
    onNextClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val colors = CustomTheme.colorScheme
    val typography = CustomTheme.typography
    val shapes = CustomTheme.shape

    Scaffold(
        modifier = modifier,
        containerColor = colors.background,
        bottomBar = {
            // Tombol di bawah
            Button(
                onClick = onNextClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                shape = shapes.button,
                colors = ButtonDefaults.buttonColors(containerColor = colors.primary)
            ) {
                Text("Next", color = colors.onPrimary, style = typography.labelLarge)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp, vertical = 16.dp),
        ) {
            // Icon Close di pojok kanan atas
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    tint = colors.onBackground,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Konten utama
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.illustration_1),
                    contentDescription = "Illustration",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "About the test",
                    style = typography.titleNormal,
                    color = colors.onBackground
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "A 20-30 minute test of TOEFL reading exercise",
                    style = typography.body,
                    color = colors.onBackground,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                Column(
                    verticalArrangement = Arrangement.spacedBy(CustomTheme.size.small)
                ) {
                    StepItem(number = 1, text = "Reading to find information")
                    StepItem(number = 2, text = "Basic comprehension")
                    StepItem(number = 3, text = "Reading to learn")
                }
            }
        }
    }
}


@Composable
fun StepItem(number: Int, text: String) {
    val colors = CustomTheme.colorScheme
    val typography = CustomTheme.typography

    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .border(2.dp, colors.onBackground, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = number.toString(),
                fontWeight = FontWeight.Bold,
                color = colors.onBackground,
                style = typography.labelLarge
            )
        }
        Spacer(modifier = Modifier.width(CustomTheme.size.small))
        Text(
            text = text,
            style = typography.body,
            color = colors.onBackground
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    CustomTheme {
        OnboardingScreen()
    }
}
