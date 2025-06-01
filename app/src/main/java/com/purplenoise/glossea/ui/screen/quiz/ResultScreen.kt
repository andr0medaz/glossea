// ui/screen/quiz/ResultScreen.kt
package com.purplenoise.glossea.ui.screen.quiz

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.purplenoise.glossea.R // Pastikan Anda punya gambar ilustrasi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(
    navController: NavController,
    score: Int
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Test Result") },
                navigationIcon = {
                    IconButton(onClick = { /* Kembali ke Home */
                        navController.navigate("learning_plan_screen") {
                            popUpTo(0) // Membersihkan backstack
                        }
                    }) {
                        Icon(Icons.Default.Close, contentDescription = "Close")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Ganti R.drawable.result_illustration dengan aset gambar Anda
            Image(
                painter = painterResource(id = R.drawable.result),
                contentDescription = "Test Result Illustration"
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "This your test result :",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = score.toString(),
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = "Nice Score !",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    navController.navigate("learning_plan") {
                        // untuk kembali ke layar awal dan membersihkan histori
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Home", modifier = Modifier.padding(8.dp))
            }
        }
    }
}