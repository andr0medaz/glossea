package com.purplenoise.glossea.ui.screen.reading

import androidx.compose.foundation.Image
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.purplenoise.glossea.R

@Composable
fun ReadingSimulationTest(
    question: String,
    options: List<String>,
    correctAnswer: String,
    onNext: (Boolean) -> Unit
) {
    var selectedOption by remember { mutableStateOf<String?>(null) }
    var isAnswered by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { /* Handle close */ }) {
                Icon(Icons.Default.Close, contentDescription = "Close")
            }
            Text("Reading Test", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.width(48.dp)) // untuk sejajar dengan IconButton
        }

        // Question text
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(question, style = MaterialTheme.typography.titleMedium, textAlign = TextAlign.Center)
        }

        // Options
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            options.forEach { option ->
                Button(
                    onClick = {
                        selectedOption = option
                        isAnswered = true
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = when {
                            !isAnswered && selectedOption == option -> Color.Yellow
                            else -> Color.LightGray
                        }
                    )
                ) {
                    Text(option)
                }
            }
        }

        // Feedback
        if (isAnswered) {
            if (selectedOption == correctAnswer) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(R.drawable.illustration_1),
                        contentDescription = "Correct Answer"
                    )
                    Text("TRUE", fontWeight = FontWeight.Bold)
                }
            } else {
                Image(
                    painter = painterResource(R.drawable.beranda),
                    contentDescription = "Wrong Answer",
                    modifier = Modifier.height(150.dp)
                )
            }
        }

        // Next button
        Button(
            onClick = {
                onNext(selectedOption == correctAnswer)
                selectedOption = null
                isAnswered = false
            },
            enabled = selectedOption != null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Next")
        }
    }
}
