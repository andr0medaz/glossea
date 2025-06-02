// presentation/quiz/QuizState.kt

package com.purplenoise.glossea.presentation.quiz

import com.purplenoise.glossea.data.model.Question

data class QuizState(
    val isLoading: Boolean = false,
    val questions: List<Question> = emptyList(),
    val currentQuestionIndex: Int = 0,
    val score: Int = 0,
    val selectedAnswer: String? = null,
    val isAnswerCorrect: Boolean? = null,
    val isQuizFinished: Boolean = false,
    val error: String? = null
) {
    // Fungsi bantuan untuk mengambil soal yang aktif saat ini
    fun currentQuestion(): Question? {
        return questions.getOrNull(currentQuestionIndex)
    }
}
