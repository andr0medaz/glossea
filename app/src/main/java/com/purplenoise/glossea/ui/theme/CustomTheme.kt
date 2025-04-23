package com.purplenoise.glossea.ui.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val darkColorScheme = CustomColorScheme(
    background = gray,
    onBackground = TestWarna1,
    primary = black,
    onPrimary = TestWarna1,
    secondary = TestWarna1,
    onSecondary = TestWarna1

)

private val lightColorScheme = CustomColorScheme(
    background = white,
    onBackground = TestWarna1,
    primary = black,
    onPrimary = yellow,
    secondary = TestWarna1,
    onSecondary = TestWarna1
)

private val typography = CustomTypography(
    titleLarge = TextStyle(
        fontFamily = Maison_Neue,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    titleNormal = TextStyle(
        fontFamily = Maison_Neue,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    body = TextStyle(
        fontFamily = Maison_Neue,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    labelLarge = TextStyle(
        fontFamily = Maison_Neue,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    labelNormal = TextStyle(
        fontFamily = Maison_Neue,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Maison_Neue,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp
    )
)

private val shape = CustomShape(
    container = RoundedCornerShape(16.dp),
    button = RoundedCornerShape(8.dp)
)

private val size = CustomSize(
    large = 24.dp,
    medium = 16.dp,
    normal = 12.dp,
    small = 8.dp
)

@Composable
fun CustomTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (isDarkTheme) darkColorScheme else lightColorScheme
    val rippleIndication = ripple()
    CompositionLocalProvider(
        LocalCustomColorScheme provides colorScheme,
        LocalCustomTypography provides typography,
        LocalCustomShape provides shape,
        LocalCustomSize provides size,
        LocalIndication provides rippleIndication,
        content = content
    )
}

object CustomTheme{
    val colorScheme: CustomColorScheme
        @Composable
        get() = LocalCustomColorScheme.current

    val typography: CustomTypography
        @Composable
        get() = LocalCustomTypography.current

    val shape: CustomShape
        @Composable
        get() = LocalCustomShape.current

    val size: CustomSize
        @Composable
        get() = LocalCustomSize.current
}


