package com.purplenoise.glossea.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.purplenoise.glossea.ui.component.atom.PrimaryButton
import com.purplenoise.glossea.ui.screen.OnboardingScreen
import com.purplenoise.glossea.ui.screen.OnboardingScreenScaffold
import com.purplenoise.glossea.ui.theme.CustomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CustomTheme {
                OnboardingScreenScaffold(
                    onNextClick = {
                        // Aksi ketika klik "Next"
                    }
                )
            }
        }
    }
}


