package ru.veider.shifttest.presentation.screens.main

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import retrofit2.HttpException
import ru.veider.shifttest.R
import ru.veider.shifttest.presentation.MainViewModel
import java.net.UnknownHostException

@Composable
fun CardInfo() {

    val context = LocalContext.current

    val viewModel: MainViewModel = koinViewModel()

    val state = viewModel.cardDataState.collectAsState()

    val text = state.value.cardNumber

    val maxNum = 16

    var height by remember { mutableStateOf(0) }

    Column(modifier = Modifier.padding(dimensionResource(id = R.dimen.global_padding))) {
        Row(modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.global_padding))) {
            OutlinedTextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                value = text,
                onValueChange = {
                    if (it.length <= maxNum) viewModel.textUpdate(it)
                },
                singleLine = true,
                placeholder = { Text(stringResource(id = R.string.search_placeholder_text)) },
                modifier = Modifier
                    .weight(1f)
                    .onGloballyPositioned { coo -> height = coo.size.height }
                    .align(CenterVertically)
                    .padding(end = dimensionResource(
                        id = R.dimen.global_padding
                    )
                    )
            )
            Button(onClick = {
                Log.d("TAG", "Кнопка нажата: $text")
                if (text.isEmpty())
                    Toast.makeText(context, context.resources.getString(R.string.zero_length), Toast.LENGTH_LONG).show()
                else if (text.length < 4)
                    Toast.makeText(context, context.resources.getString(R.string.short_length), Toast.LENGTH_LONG).show()
                else {
                    viewModel.getCardInfo(text.toLong()
                    )
                }
            },
                   modifier = Modifier
                       .height((height / context.resources.displayMetrics.density).dp)
                       .align(CenterVertically)
            )
            {
                Icon(painter = painterResource(id = R.drawable.info),
                     contentDescription = stringResource(id = R.string.search_button_text)
                )
            }
        }

        if (state.value.error != null) {
            Box(contentAlignment = Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Log.d("TAG", "CardNumber: " + state.value.error.toString())
                val str: String = when (val exception = state.value.error) {
                    is HttpException        -> {
                        when (exception.code()) {
                            400 ->
                                stringResource(id = R.string.error_400)
                            404 ->
                                stringResource(id = R.string.error_404)
                            else -> exception.response().toString()
                        }
                    }
                    is UnknownHostException ->
                        stringResource(id = R.string.error_unknown_host)
                    else                    ->
                        exception?.cause?.message.toString()
                }
                Text("${stringResource(id = R.string.error)} $str")
            }
        } else if (state.value.card != null) {
            Row {
                ru.veider.shifttest.presentation.screens.common.CardInfo(state.value.card!!)
            }
        }
    }
}