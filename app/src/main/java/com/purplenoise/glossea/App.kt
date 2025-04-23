package com.purplenoise.glossea

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.purplenoise.glossea.ui.screen.HomeScreen
import com.purplenoise.glossea.ui.screen.OnboardingScreenScaffold
import com.purplenoise.glossea.ui.theme.CustomTheme

@Composable
fun MyApp() {
    CustomTheme {
        val navController = rememberNavController()
        NavHost(navController, startDestination = "home") {
            composable("home") { HomeScreen(navController = navController) }
            composable("reading-test") { OnboardingScreenScaffold() }
        }
    }
}
