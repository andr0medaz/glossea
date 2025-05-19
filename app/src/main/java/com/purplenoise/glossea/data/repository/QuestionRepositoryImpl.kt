package com.purplenoise.glossea.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.purplenoise.glossea.data.model.Question
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuestionRepositoryImpl @Inject constructor() : QuestionRepository {
    private val firestore = FirebaseFirestore.getInstance()

    override suspend fun getQuestions(): List<Question> = withContext(Dispatchers.IO) {
        val snapshot = firestore.collection("questions").get().await()
        return@withContext snapshot.documents.mapNotNull { it.toObject(Question::class.java) }
    }
}