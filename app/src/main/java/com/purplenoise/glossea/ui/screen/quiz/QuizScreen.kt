// ui/screen/quiz/QuizScreen.kt

package com.purplenoise.glossea.ui.screen.quiz

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.purplenoise.glossea.R
import com.purplenoise.glossea.presentation.quiz.QuizViewModel

@Composable
fun QuizScreen(
    navController: NavController,
    viewModel: QuizViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    // UNTUK Listen KAPAN KUIS SELESAI
    // LaunchedEffect akan berjalan hanya satu kali ketika isQuizFinished berubah menjadi true
    LaunchedEffect(state.isQuizFinished) {
        if (state.isQuizFinished) {
            // Pindah ke layar hasil sambil mengirim skor
            navController.navigate("result_screen/${state.score}") {
                // Hapus QuizScreen dari backstack agar pengguna tidak bisa kembali ke kuis yang sudah selesai
                popUpTo("simulation_reading") { inclusive = true }
            }
        }
    }

    if (state.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
        return
    }

    // Gunakan Box untuk bisa menumpuk konten dengan overlay feedback
    Box(modifier = Modifier.fillMaxSize()) {
        state.currentQuestion()?.let { currentQuestion ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Tampilkan teks pertanyaan (pastikan nama properti benar)
                Text(
                    text = currentQuestion.question,
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Tampilkan tombol-tombol pilihan jawaban
                currentQuestion.options.forEach { option ->
                    AnswerOptionButton(
                        optionText = option,
                        correctAnswer = currentQuestion.correctAnswer,
                        selectedAnswer = state.selectedAnswer,
                        onOptionSelected = {
                            // Panggil fungsi di ViewModel saat tombol ditekan
                            viewModel.onAnswerSelected(option)
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }

        // Overlay Feedback (Benar/Salah)
        AnimatedVisibility(
            visible = state.selectedAnswer != null,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            FeedbackOverlay(isCorrect = state.isAnswerCorrect)
        }
    }
}

@Composable
fun AnswerOptionButton(
    optionText: String,
    correctAnswer: String,
    selectedAnswer: String?,
    onOptionSelected: () -> Unit
) {
    val hasAnswerBeenSelected = selectedAnswer != null
    val isThisButtonSelected = optionText == selectedAnswer
    val isThisButtonCorrect = optionText == correctAnswer

    val buttonColors = when {
        // Setelah dijawab, jika tombol ini adalah jawaban yang benar -> HIJAU
        hasAnswerBeenSelected && isThisButtonCorrect ->
            ButtonDefaults.buttonColors(containerColor = Color(0xFF58CC02), contentColor = Color.White)

        // Setelah dijawab, jika tombol ini yang dipilih TAPI salah -> MERAH
        hasAnswerBeenSelected && isThisButtonSelected && !isThisButtonCorrect ->
            ButtonDefaults.buttonColors(containerColor = Color(0xFFEF4444), contentColor = Color.White)

        // Setelah dijawab, tombol lain yang tidak dipilih -> FADED/ABU-ABU
        hasAnswerBeenSelected ->
            ButtonDefaults.buttonColors(containerColor = Color.LightGray.copy(alpha = 0.5f), contentColor = Color.DarkGray)

        // Kondisi awal (belum dijawab)
        else -> ButtonDefaults.outlinedButtonColors()
    }

    val border = if (hasAnswerBeenSelected) null else BorderStroke(1.dp, MaterialTheme.colorScheme.primary)

    Button(
        onClick = onOptionSelected,
        modifier = Modifier.fillMaxWidth(),
        enabled = !hasAnswerBeenSelected, // Tombol dinonaktifkan setelah jawaban dipilih
        colors = buttonColors,
        border = border,
        contentPadding = PaddingValues(16.dp)
    ) {
        Text(text = optionText)
    }
}

@Composable
fun FeedbackOverlay(isCorrect: Boolean?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.6f)),
        contentAlignment = Alignment.Center
    ) {
        val imageRes = when (isCorrect) {
            true -> R.drawable.true_image
            false -> R.drawable.wrong
            else -> null
        }
        imageRes?.let {
            Image(painter = painterResource(id = it), contentDescription = "Feedback")
        }
    }
}