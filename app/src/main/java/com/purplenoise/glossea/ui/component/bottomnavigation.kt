package com.purplenoise.glossea.ui.component
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.purplenoise.glossea.R
import com.purplenoise.glossea.ui.theme.CustomTheme


@Composable
fun BottomBar(modifier: Modifier = Modifier) {
    NavigationBar(modifier) {
        val bottomNavigation = listOf(
            BottomBarItem(
                title = stringResource(id = R.string.txt_home),
                icon = R.drawable.beranda
            ),
            BottomBarItem(
                title = stringResource(id = R.string.txt_latihan),
                icon = R.drawable.latihan
            ),
            BottomBarItem(
                title = stringResource(id = R.string.txt_simulasi),
                icon = R.drawable.profil
            ), BottomBarItem(
                title = stringResource(id = R.string.txt_profil),
                icon = R.drawable.simulasi
            )
        )
        bottomNavigation.map {
            NavigationBarItem(
                selected = it.title == bottomNavigation[0].title,
                onClick = { },
                icon = {
                    Icon(
                        painter = painterResource(id = it.icon),
                        contentDescription = it.title,
                        modifier = Modifier.size(32.dp)
                    )
                },
                label = { Text(text = it.title) }
            )
        }
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    CustomTheme {
        BottomBar()
    }
}
