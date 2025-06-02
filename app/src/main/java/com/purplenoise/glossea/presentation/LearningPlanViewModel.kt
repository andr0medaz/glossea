//presentation/LearningPlanViewModel.kt

package com.purplenoise.glossea.presentation

import androidx.lifecycle.ViewModel
import com.purplenoise.glossea.data.model.LearningPlan
import com.purplenoise.glossea.data.repository.LearningRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LearningPlanViewModel @Inject constructor(
    private val repository: LearningRepository
) : ViewModel() {

    private val _learningPlans = MutableStateFlow<List<LearningPlan>>(emptyList())
    val learningPlans =  _learningPlans.asStateFlow()

    init {
        _learningPlans.value = repository.getLearningPlans()
    }
}