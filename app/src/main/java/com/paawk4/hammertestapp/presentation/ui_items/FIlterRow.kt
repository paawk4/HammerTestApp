package com.paawk4.hammertestapp.presentation.ui_items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.paawk4.hammertestapp.presentation.theme.BgColor

@Composable
fun FilterRow() {

    LazyRow(
        modifier = Modifier.fillMaxWidth().background(BgColor),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val listOfFilters = listOf("Пицца", "Комбо", "Десерты", "Напитки")
        items(listOfFilters) {
            FilterItem(text = it)
        }
    }

}