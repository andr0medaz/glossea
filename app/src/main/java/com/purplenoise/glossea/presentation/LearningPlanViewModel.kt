//presentation/LearningPlanViewModel.kt

package com.purplenoise.glossea.presentation

import androidx.lifecycle.ViewModel
import com.purplenoise.glossea.data.model.LearningPlan
import com.purplenoise.glossea.data.repository.LearningRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LearningPlanViewModel @Inject constructor(
    private val repository: LearningRepository
) : ViewModel() {

    private val _learningPlan = MutableStateFlow<LearningPlan?>(null)
    val learningPlan: StateFlow<LearningPlan?> = _learningPlan

    init {
        _learningPlan.value = repository.getLearningPlan()
    }
}