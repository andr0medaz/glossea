// data/repository/LearningRepository.kt
package com.purplenoise.glossea.data.repository

import com.purplenoise.glossea.data.model.LearningPlan

interface LearningRepository {
    fun getLearningPlan(): LearningPlan
}