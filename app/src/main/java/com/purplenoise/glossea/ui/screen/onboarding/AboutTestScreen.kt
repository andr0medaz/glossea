package com.purplenoise.glossea.ui.screen.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.purplenoise.glossea.R

@Composable
fun OnBoardingAboutTestScreen(onNextClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = { /* Optional close */ }) {
                    Icon(Icons.Default.Close, contentDescription = "Close")
                }
            }

            Text("About the test", style = MaterialTheme.typography.titleLarge)
            Spacer(Modifier.height(16.dp))

            Image(
                painter = painterResource(R.drawable.illustration_1),
                contentDescription = "About the test ilustration",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)

            )
            Spacer(Modifier.height(16.dp))

            Text("A 20-30 minute test of TOEFL reading exercise", style = MaterialTheme.typography.bodyMedium)
            val items = listOf(
                "Reading to find information",
                "Basic comprehension",
                "Reading to learn"
            )

            items.forEachIndexed { i, item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Text("${i + 1}.", fontWeight = FontWeight.Bold)
                    Spacer(Modifier.width(8.dp))
                    Text(item)
                }
            }
        }

        Button(
            onClick = onNextClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Next")
        }
    }
}

