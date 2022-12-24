package ru.veider.shifttest.presentation.screens

import android.Manifest
import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.*
import ru.veider.shifttest.R

@ExperimentalPermissionsApi
@Composable
fun PermissionsRequest(
    onGranted: @Composable () -> Unit
) {
    val permissionsList = arrayListOf(Manifest.permission.CALL_PHONE
    )
    val permissionsState = rememberMultiplePermissionsState(permissions = permissionsList)
    val context = LocalContext.current

    when {
        permissionsState.allPermissionsGranted -> {
            onGranted()
        }
        else                                   -> {
            Column(modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(1f),
                   verticalArrangement = Arrangement.Center,
                   horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(LocalContext.current.resources.getString(R.string.permission_title), textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(20.dp))
                ShowPermissionButton(permissionsState = permissionsState, permissionsList = permissionsList,
                                     permission = Manifest.permission.CALL_PHONE, buttonText = R.string.permission_call_phone
                )
                Spacer(modifier = Modifier.height(50.dp))
                TextButton(modifier = Modifier.fillMaxWidth(), onClick = { (context as Activity).finish() }) {
                    Text(LocalContext.current.resources.getString(R.string.permission_cancelled))
                }
            }
        }
    }
}

@ExperimentalPermissionsApi
@Composable
fun ShowPermissionButton(permissionsState: MultiplePermissionsState, permissionsList: List<String>, permission: String, buttonText: Int) {
    val permissionIndex = permissionsList.indexOf(permission)
    if (!permissionsState.permissions[permissionIndex].status.isGranted) {
        Button(modifier = Modifier.fillMaxWidth(),
               onClick = { permissionsState.permissions[permissionIndex].launchPermissionRequest() }) {
            Text(text = LocalContext.current.resources.getString(buttonText))
        }
    }
}