package com.purplenoise.glossea

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.purplenoise.glossea.presentation.LearningPlanViewModel
import com.purplenoise.glossea.ui.screen.LearningPlanScreen
import com.purplenoise.glossea.ui.theme.GlosseaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GlosseaTheme {
                val viewModel: LearningPlanViewModel = hiltViewModel()
                LearningPlanScreen(viewModel)
            }
        }
    }
}
