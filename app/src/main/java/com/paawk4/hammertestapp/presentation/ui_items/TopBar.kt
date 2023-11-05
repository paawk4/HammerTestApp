package com.paawk4.hammertestapp.presentation.ui_items

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paawk4.hammertestapp.R

@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(16.dp)
    ) {
        Row(modifier = Modifier.align(Alignment.CenterStart)) {
            Text(text = "Москва")
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = null
            )
        }
        Icon(
            painterResource(id = R.drawable.ic_qr_code),
            contentDescription = "qr",
            modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
        )
    }
}