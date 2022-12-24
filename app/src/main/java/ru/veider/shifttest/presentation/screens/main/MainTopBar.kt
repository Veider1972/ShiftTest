package ru.veider.shifttest.presentation.screens.main

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ru.veider.shifttest.R

@Composable
fun MainTopBar() {
    TopAppBar(
        title= {Text(stringResource(id = R.string.app_name))})
}
