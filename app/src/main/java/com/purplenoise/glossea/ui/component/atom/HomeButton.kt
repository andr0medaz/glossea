package com.purplenoise.glossea.ui.component.atom

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.purplenoise.glossea.R
import com.purplenoise.glossea.ui.theme.CustomTheme

@Composable
fun HomeButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val colors = CustomTheme.colorScheme// Ambil warna dari theme kamu

    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = colors.background, // Warna dari CustomTheme
            contentColor = colors.primary
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.frame),
                contentDescription = "Home Icon",
                modifier = Modifier.size(24.dp),
                tint = colors.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Home",
                color = colors.primary
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeButtonPreview() {
    CustomTheme {
        HomeButton(onClick = {})
    }

}
