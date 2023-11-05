package com.paawk4.hammertestapp.presentation.ui_items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paawk4.hammertestapp.presentation.theme.UnFocusedFilterText

@Composable
fun FilterItem(text: String) {
    Text(
        text = text,
        fontSize = 16.sp,
        color = UnFocusedFilterText,
        modifier = Modifier
            .background(Color.White, shape = RoundedCornerShape(6.dp))
            .padding(horizontal = 24.dp, vertical = 8.dp)
    )
}