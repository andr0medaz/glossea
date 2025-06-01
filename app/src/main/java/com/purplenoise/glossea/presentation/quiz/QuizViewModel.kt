// presentation/quiz/QuizViewModel.kt

package com.purplenoise.glossea.presentation.quiz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.purplenoise.glossea.data.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val repository: QuestionRepository
) : ViewModel() {
    // Kita hanya punya SATU state ini sekarang.
    private val _state = MutableStateFlow(QuizState())
    val state = _state.asStateFlow() // UI akan mengamati state ini

    init {
        loadQuestions()
    }

    private fun loadQuestions() {
        viewModelScope.launch {
            // Update state menjadi "loading"
            _state.update { it.copy(isLoading = true) }

            try {
                val questionList = repository.getQuestions()
                // Jika berhasil, update state dengan data yang didapat
                _state.update {
                    it.copy(
                        isLoading = false,
                        questions = questionList
                    )
                }
            } catch (e: Exception) {
                // Jika error, update state dengan pesan error
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "Gagal memuat soal."
                    )
                }
            }
        }
    }

    fun onAnswerSelected(selectedOption: String) {
        // Mencegah klik ganda
        if (_state.value.selectedAnswer != null) return

        viewModelScope.launch {
            val currentQuestion = _state.value.currentQuestion()!!
            val isCorrect = currentQuestion.correctAnswer == selectedOption

            // 1. Update state dengan jawaban pengguna & status benar/salah
            _state.update {
                it.copy(
                    selectedAnswer = selectedOption,
                    isAnswerCorrect = isCorrect,
                    score = if (isCorrect) it.score + 10 else it.score
                )
            }

            // jeda 2 detik
            delay(2000L)

            // Pindah ke soal berikutnya
            moveToNextQuestion()
        }
    }

    private fun moveToNextQuestion() {
        val currentState = _state.value
        if (currentState.currentQuestionIndex < currentState.questions.size - 1) {
            _state.update {
                it.copy(
                    currentQuestionIndex = it.currentQuestionIndex + 1,
                    selectedAnswer = null,
                    isAnswerCorrect = null
                )
            }
        } else {
            // Kuis selesai
            _state.update { it.copy(isQuizFinished = true) }
        }
    }

}