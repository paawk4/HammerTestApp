package com.paawk4.hammertestapp.domain.models

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

data class Meal(
    @SerializedName("strMeal")
    val name: String,
    @SerializedName("strMealThumb")
    val img: String,
    @SerializedName("idMeal")
    val id: String,
)

data class Meals(
    val meals: List<Meal>
)