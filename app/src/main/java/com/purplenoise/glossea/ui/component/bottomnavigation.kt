package com.purplenoise.glossea.ui.component
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.purplenoise.glossea.R
import com.purplenoise.glossea.ui.theme.CustomTheme
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart


@Composable
fun BottomBar(modifier: Modifier = Modifier) {
    NavigationBar(modifier) {
        val bottomNavigation = listOf(
            BottomBarItem(
                title = stringResource(id = R.string.txt_home),
                icon = Icons.Default.Home
            ),
            BottomBarItem(
                title = stringResource(id = R.string.txt_home),
                icon = Icons.Default.ShoppingCart
            ),
            BottomBarItem(
                title = stringResource(id = R.string.txt_home),
                icon = Icons.Default.Notifications
            ), BottomBarItem(
                title = stringResource(id = R.string.txt_home),
                icon = Icons.Default.Person
            )
        )
        bottomNavigation.map {
            NavigationBarItem(
                selected = it.title == bottomNavigation[0].title,
                onClick = { },
                icon = {
                    androidx.compose.material3.Icon(
                        imageVector = it.icon,
                        contentDescription = it.title
                    )
                },
                label = { Text(text = it.title) })
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
