// data/repository/QuestionRepository.kt
package com.purplenoise.glossea.data.repository

import com.purplenoise.glossea.data.model.Question

interface QuestionRepository {
    suspend fun getQuestions(): List<Question>
}