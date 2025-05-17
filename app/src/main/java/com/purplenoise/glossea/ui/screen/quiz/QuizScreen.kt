package com.purplenoise.glossea.ui.screen.quiz

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.purplenoise.glossea.presentation.quiz.QuizViewModel
import androidx.compose.foundation.lazy.items

@Composable
fun QuizScreen(viewModel: QuizViewModel = hiltViewModel()) {
    val questions = viewModel.questions
    val isLoading = viewModel.isLoading

    if (isLoading) {
        CircularProgressIndicator()
    } else {
        LazyColumn {
            items(questions) { question ->
                Text(text = question.question)
                question.options.forEach { option ->
                    Text(text = ". $option")
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}