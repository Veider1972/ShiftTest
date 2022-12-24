package ru.veider.shifttest.presentation.screens.cache

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import ru.veider.shifttest.presentation.navigation.NavigationDestination
import ru.veider.shifttest.R

@Composable
fun CacheAppBar(navController: NavController) {
    TopAppBar(
        title = { Text(stringResource(id = R.string.app_name)) },
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate(NavigationDestination.MainScreen.destination)
            }) {
                Icon(painter = painterResource(id = R.drawable.back), contentDescription = "")
            }
        })
}