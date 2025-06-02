package com.purplenoise.glossea.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.purplenoise.glossea.R
import com.purplenoise.glossea.data.model.LearningPlan
import com.purplenoise.glossea.presentation.LearningPlanViewModel


@Composable
fun LearningPlanScreen(
    viewModel: LearningPlanViewModel = hiltViewModel(),
    onStartClick: (planId: String) -> Unit // Callback untuk navigasi saat tombol "Start" diklik
) {
    val learningPlans by viewModel.learningPlans.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
        contentPadding = PaddingValues(vertical = 24.dp)
    ) {
        // Header Profil
        item {
            HeaderProfileSection(name = "Leon", modifier = Modifier.padding(horizontal = 16.dp))
        }

        // Banner Promo/Informasi
        item {
            Spacer(modifier = Modifier.height(24.dp))
            PromoBannerSection()
        }

        // Heading "Learning Plan"
        item {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Learning Plan",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Daftar Kartu Learning Plan dari ViewModel
        items(learningPlans) { plan ->
            LearningPlanItem(
                plan = plan,
                onStartClick = { onStartClick(plan.id) },
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Item "Coming Soon"
        item {
            ComingSoonItem(modifier = Modifier.padding(horizontal = 16.dp))
        }
    }
}

// Komponen yang digunakan pada learning plan screen (screen ini)
@Composable
fun HeaderProfileSection(name: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = "Hi, $name", style = MaterialTheme.typography.titleMedium)
            Text(text = "Semangat belajarnya !", style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
        }
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Profile",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.Gray.copy(alpha = 0.2f))
                .padding(8.dp)
        )
    }
}


// Komponen banner
@OptIn(com.google.accompanist.pager.ExperimentalPagerApi::class)
@Composable
fun PromoBannerSection(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState()
    val bannerCount = 3

    HorizontalPager(
        count = bannerCount,
        state = pagerState,
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp),
        itemSpacing = 16.dp
    ) {
        Card(
            modifier = Modifier.fillMaxWidth().height(150.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = R.drawable.wrong),
                    contentDescription = "Promo Background",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.3f))
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text("Diskon 50%", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    Text("untuk Berlangganan 1 tahun", fontSize = 14.sp, color = Color.White)
                }
            }
        }
    }
}

// Komponen kartu rencana belajar
@Composable
fun LearningPlanItem(plan: LearningPlan, onStartClick: () -> Unit, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = plan.imageRes),
                contentDescription = plan.title,
                modifier = Modifier.size(80.dp).clip(RoundedCornerShape(12.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = plan.title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = plan.description, style = MaterialTheme.typography.bodySmall, maxLines = 4, color = Color.DarkGray)
                Spacer(modifier = Modifier.height(12.dp))
                Button(onClick = onStartClick) {
                    Text("Start Now")
                }
            }
        }
    }
}

// Komponen "Coming Soong" Card
@Composable
fun ComingSoonItem(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE8E8E8)) // Warna abu-abu sedikit lebih gelap
    ) {
        Box(modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp), contentAlignment = Alignment.Center) {
            Text("Listening & Speaking Coming Soon", color = Color.Gray, fontWeight = FontWeight.Medium)
        }
    }
}