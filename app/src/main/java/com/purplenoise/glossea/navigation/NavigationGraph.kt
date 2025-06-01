// navigation/AppNavGraph.kt
package com.purplenoise.glossea.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.purplenoise.glossea.presentation.LearningPlanViewModel
import com.purplenoise.glossea.ui.screen.LearningPlanScreen
import com.purplenoise.glossea.ui.screen.onboarding.OnBoardingAboutTestScreen
import com.purplenoise.glossea.ui.screen.quiz.QuizScreen
import com.purplenoise.glossea.ui.screen.quiz.ResultScreen
import com.purplenoise.glossea.ui.screen.reading.ReadingSimulationTest

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "learning_plan") {
        // route pertama (home screen)
        composable("learning_plan") {
            val viewModel: LearningPlanViewModel = hiltViewModel()
            LearningPlanScreen(viewModel) {
                navController.navigate("about_test")
            }
        }

        // route kedua (about test screen)
        composable("about_test") {
            OnBoardingAboutTestScreen (
                onNextClick = {
                    navController.navigate("simulation_reading")
                }
            )
        }

        // route ketiga (test simulation)
        composable("simulation_reading") {
            QuizScreen(navController = navController)
        }

        composable(
            route = "result_screen/{score}", // Definisikan rute dengan argumen score
            arguments = listOf(navArgument("score") { type = NavType.IntType })
        ) { backStackEntry ->
            // Ambil argumen skor dari rute
            val score = backStackEntry.arguments?.getInt("score") ?: 0
            ResultScreen(navController = navController, score = score)
        }

    }
}