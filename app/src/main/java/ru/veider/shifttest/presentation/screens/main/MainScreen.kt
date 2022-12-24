package ru.veider.shifttest.presentation.screens.main

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import ru.veider.shifttest.presentation.navigation.NavigationDestination
import ru.veider.shifttest.R
import ru.veider.shifttest.presentation.theme.ShiftTestTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavController) {
    ShiftTestTheme {
        Scaffold(
            topBar = { MainTopBar() },
            content = { CardInfo() },
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { Text(stringResource(id = R.string.history_button_text))},
                    onClick = { navController.navigate(NavigationDestination.CacheScreen.destination) },
                    icon = { Icon(painterResource(id = R.drawable.history), "") })
            }
        )
    }
}
