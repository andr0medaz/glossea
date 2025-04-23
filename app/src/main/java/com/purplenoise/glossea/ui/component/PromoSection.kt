package com.purplenoise.glossea.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.purplenoise.glossea.R
import com.purplenoise.glossea.ui.theme.CustomTheme

@Composable
fun PromoCard() {
    val colors = CustomTheme.colorScheme
    val typography = CustomTheme.typography

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .background(Color.White.copy(alpha = 0.2f), shape = CustomTheme.shape.container)
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.align(Alignment.CenterStart)) {
            Text("Diskon 50%", style = typography.titleNormal, color = Color.Green)
            Text("untuk Berlangganan 1 tahun", style = typography.body, color = Color.White)
            Text(
                "Nikmati keuntungan update materi terbaru, dan exam tanpa batas",
                style = typography.labelNormal,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
//                Image(painterResource(R.drawable.ic_bca), contentDescription = null)
//                Image(painterResource(R.drawable.ic_bni), contentDescription = null)
//                Image(painterResource(R.drawable.ic_visa), contentDescription = null)
            }
        }

//        Image(
//            painter = painterResource(id = R.drawable.ic_promo_image),
//            contentDescription = null,
//            modifier = Modifier
//                .align(Alignment.CenterEnd)
//                .width(100.dp)
//                .clip(CustomTheme.shape.container),
//            contentScale = ContentScale.Crop
//        )
    }
}
