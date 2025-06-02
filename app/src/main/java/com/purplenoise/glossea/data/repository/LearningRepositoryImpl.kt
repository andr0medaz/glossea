// data/repository/LearningRepositoryImpl.kt
package com.purplenoise.glossea.data.repository

import com.purplenoise.glossea.R
import com.purplenoise.glossea.data.model.LearningPlan
import javax.inject.Inject

class LearningRepositoryImpl @Inject constructor() : LearningRepository {
    override fun getLearningPlans(): List<LearningPlan> {
        return listOf(
            LearningPlan(
                id = "reading",
                title = "TOEFL® Reading. Academic Reading Skills.",
                description = "The Reading section measures test takers' ability to understand university-level academic texts and passages.",
                imageRes = R.drawable.ilustration_reading
            ),
            LearningPlan(
                id = "writing",
                title = "TOEFL® Writing (COMING SOON)",
                description = "The writing section is the final part of the TOEFL® test. You'll have about 30 minutes to answer two writing questions.",
                imageRes = R.drawable.ilustration_writing
            )
        )
    }
}