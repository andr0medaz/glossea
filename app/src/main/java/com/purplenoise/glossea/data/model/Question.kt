// data/model/Question.kt
package com.purplenoise.glossea.data.model

data class Question(
    val question: String = "",
    val options: List<String> = emptyList(),
    val correctAnswer: String = ""
)


