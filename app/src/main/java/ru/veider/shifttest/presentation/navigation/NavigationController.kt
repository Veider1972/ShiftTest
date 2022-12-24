package ru.veider.shifttest.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.koin.androidx.compose.koinViewModel
import ru.veider.shifttest.presentation.MainViewModel
import ru.veider.shifttest.presentation.screens.cache.CacheScreen
import ru.veider.shifttest.presentation.screens.main.MainScreen

@Composable
fun NavController(navController: NavHostController, startDestination: String) {
    NavHost(navController, startDestination = startDestination) {
        composable(NavigationDestination.MainScreen.destination) {
            MainScreen(navController)
        }
        composable(NavigationDestination.CacheScreen.destination) {
            (koinViewModel() as MainViewModel).getCache()
            CacheScreen(navController)
        }
    }
}