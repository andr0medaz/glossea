package com.purplenoise.glossea.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.purplenoise.glossea.R
import com.purplenoise.glossea.ui.component.BottomBar
import com.purplenoise.glossea.ui.component.ComingSoonCard
import com.purplenoise.glossea.ui.component.GreetingSection
import com.purplenoise.glossea.ui.component.LearningPlanCard
import com.purplenoise.glossea.ui.component.PromoCard
import com.purplenoise.glossea.ui.theme.CustomTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    userName: String = "Leon",
    navController: NavController
) {
    val colors = CustomTheme.colorScheme
    val typography = CustomTheme.typography

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colors.background)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(colors.primary)
                .padding(24.dp)
        ) {
            Column {
                GreetingSection(userName)
                Spacer(modifier = Modifier.height(16.dp))
                PromoCard()
            }

            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profile",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(32.dp),
                tint = colors.onPrimary
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(
                text = "Learning Plan",
                style = typography.titleLarge,
                color = colors.onBackground
            )

            Spacer(modifier = Modifier.height(16.dp))

            LearningPlanCard(
                image = R.drawable.simulasi,
                title = "TOEFL® Reading",
                description = "The Reading section measures test takers’ ability to understand university-level academic texts and passages.",
                onClick = { navController.navigate("reading-test") }
            )

            Spacer(modifier = Modifier.height(12.dp))

            LearningPlanCard(
                image = R.drawable.simulasi,
                title = "TOEFL® Writing",
                description = "The writing section is the final part of the TOEFL® test. You’ll have about 30 minutes to answer two writing questions.",
                onClick = { navController.navigate("reading-test") }
            )

            Spacer(modifier = Modifier.height(12.dp))

            ComingSoonCard()

            BottomBar()
        }
    }
}
