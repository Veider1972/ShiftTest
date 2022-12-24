package ru.veider.shifttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import ru.veider.shifttest.presentation.navigation.NavController
import ru.veider.shifttest.presentation.screens.PermissionsRequest

@Suppress("OPT_IN_IS_NOT_ENABLED") class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            PermissionsRequest(
                onGranted = {
                    NavController(navController = navController, startDestination = "mainScreen")
                }
            )

        }
    }
}