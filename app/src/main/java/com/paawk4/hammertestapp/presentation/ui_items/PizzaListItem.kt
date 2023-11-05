package com.paawk4.hammertestapp.presentation.ui_items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.paawk4.hammertestapp.domain.models.Meal
import com.paawk4.hammertestapp.presentation.theme.AccentColor
import com.paawk4.hammertestapp.presentation.theme.Typography

@Composable
fun MealListItem(meal: Meal) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        AsyncImage(
            model = meal.img,
            contentDescription = "img",
            modifier = Modifier
                .fillMaxHeight()
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.FillHeight
        )
        Box(
            modifier = Modifier
                .padding(start = 22.dp)
                .fillMaxHeight()
        ) {
            Column {
                Text(
                    text = meal.name,
                    style = Typography.titleMedium
                )
                Text(
                    text = "Ham, champignons, increased portion of mozzarella, tomato sauce",
                    style = Typography.bodyMedium,
                    color = Color(0xFFAAAAAD),
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            Text(
                text = "599 р",
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = AccentColor,
                modifier = Modifier
                    .border(
                        BorderStroke(1.dp, AccentColor),
                        shape = RoundedCornerShape(6.dp)
                    )
                    .padding(vertical = 8.dp, horizontal = 18.dp)
                    .align(Alignment.BottomEnd)
            )
        }
    }
}