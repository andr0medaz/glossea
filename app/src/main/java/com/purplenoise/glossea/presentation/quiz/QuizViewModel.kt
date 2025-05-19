package com.purplenoise.glossea.presentation.quiz

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.purplenoise.glossea.data.model.Question
import com.purplenoise.glossea.data.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val repository: QuestionRepository
) : ViewModel() {
    var questions by mutableStateOf<List<Question>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    init {
        fetchQuestions()
    }

    private fun fetchQuestions() {
        viewModelScope.launch {
            isLoading = true
            questions = repository.getQuestions()
            isLoading = false
        }
    }
}