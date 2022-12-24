package ru.veider.shifttest.presentation.screens.common

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.core.content.ContextCompat.startActivity
import ru.veider.shifttest.R
import ru.veider.shifttest.data.repo.remote.data.CardData

@Composable
fun CardInfo(cardData: CardData) {
    val context = LocalContext.current

    Column(modifier = Modifier.padding(dimensionResource(id = R.dimen.global_padding))) {
        RowLine(titleId = R.string.card_number, value = cardData.cardNumber.toString())
        cardData.scheme?.run { RowLine(titleId = R.string.scheme_network, value = cardData.scheme) }
        cardData.brand?.run { RowLine(titleId = R.string.brand, value = cardData.brand) }
        cardData.numLength?.run { RowLine(titleId = R.string.length, value = cardData.numLength.toString()) }
        cardData.isLuhn?.run { RowLine(titleId = R.string.luhn, value = cardData.isLuhn.toString()) }
        cardData.type?.run { RowLine(titleId = R.string.type, value = cardData.type) }
        cardData.isPrepaid?.run { RowLine(titleId = R.string.predaid, value = cardData.isPrepaid.toString()) }
        cardData.countryName?.run { RowLine(titleId = R.string.country, value = cardData.countryName) }
        if (cardData.latitude != null && cardData.longitude != null) {
            Surface(modifier = Modifier.clickable {
                startActivity(context,
                              Intent(Intent.ACTION_VIEW).apply {
                                  data = Uri.parse("http://maps.google.com/maps?z=16&t=m&q=${cardData.latitude},${cardData.longitude}")
                              }, null
                )
            }) {
                Column {
                    RowLine(titleId = R.string.latitude, value = cardData.latitude.toString())
                    RowLine(titleId = R.string.longitude, value = cardData.longitude.toString())
                }
            }
        }
        cardData.bankName?.run { RowLine(titleId = R.string.bank, value = cardData.bankName) }
        cardData.bankUrl?.run {
            Surface(modifier = Modifier.clickable {
                startActivity(context,
                              Intent(Intent.ACTION_VIEW).apply {
                                  data = Uri.parse("http://${cardData.bankUrl}")
                              }, null
                )
            }) {
                RowLine(titleId = R.string.www, value = cardData.bankUrl)
            }
        }
        cardData.bankPhone?.run {
            Surface(modifier = Modifier.clickable {
                startActivity(context,
                              Intent(Intent.ACTION_CALL).apply {
                                  data = Uri.parse("tel:${cardData.bankPhone}")
                              }, null
                )
            }) {
                RowLine(titleId = R.string.phone, value = cardData.bankPhone)
            }
        }
    }
}

@Composable
fun RowLine(titleId: Int, value: String) {
    Row {
        Text(stringResource(id = titleId), modifier = Modifier
            .padding(end = dimensionResource(id = R.dimen.global_padding))
            .fillMaxWidth(0.5f)
        )
        Text(value, modifier = Modifier.fillMaxWidth(1f))
    }
}