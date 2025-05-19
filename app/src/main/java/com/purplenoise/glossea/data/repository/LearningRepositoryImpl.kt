// data/repository/LearningRepositoryImpl.kt
package com.purplenoise.glossea.data.repository

import com.purplenoise.glossea.R
import com.purplenoise.glossea.data.model.LearningPlan
import javax.inject.Inject

class LearningRepositoryImpl @Inject constructor() : LearningRepository {
    override fun getLearningPlan(): LearningPlan {
        return LearningPlan(
            title = "TOEFL® Reading. Academic Reading Skills.",
            description = "The Reading section measures test takers' ability to understand university-level academic texts and passages.",
            imageRes = R.drawable.simulasi
        )
    }
}