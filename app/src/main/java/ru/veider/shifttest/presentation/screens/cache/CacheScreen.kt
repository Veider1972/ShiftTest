package ru.veider.shifttest.presentation.screens.cache

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.veider.shifttest.R
import ru.veider.shifttest.presentation.MainViewModel
import ru.veider.shifttest.presentation.theme.ShiftTestTheme


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CacheScreen(navController: NavController) {

    val viewModel: MainViewModel = koinViewModel()

    val state = viewModel.cacheDataState.collectAsState()
    val cardList = state.value.cacheList
    val error = state.value.error

    ShiftTestTheme {
        Scaffold(
            topBar = { CacheAppBar(navController = navController) },
            bottomBar = { },
            content = {
                if (error != null)
                    Text("${stringResource(id = R.string.error)} ${error.message}")
                else if (cardList != null)
                    CacheList(cardList)
            }
        )
    }
}