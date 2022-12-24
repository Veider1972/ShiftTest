package ru.veider.shifttest.presentation.screens.cache

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import ru.veider.shifttest.R
import ru.veider.shifttest.data.repo.remote.data.CardData
import ru.veider.shifttest.presentation.screens.common.CardInfo

@Composable
fun CacheList(cardList: List<CardData>) {
    Column {
        Text(stringResource(id = R.string.archive_title), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center,
             style = MaterialTheme.typography.h6
        )
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.global_padding))
        ) {
            items(cardList.size) { i ->
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.global_padding))) {
                    CardInfo(cardList[i])
                }

            }
        }
    }
}
