package ru.veider.shifttest.presentation.navigation

sealed class NavigationDestination(val destination: String){
    object MainScreen: NavigationDestination("mainScreen")
    object CacheScreen: NavigationDestination("cacheScreen")
}
