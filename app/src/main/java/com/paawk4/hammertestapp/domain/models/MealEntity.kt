package com.paawk4.hammertestapp.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meals")
data class MealEntity(
    val name: String,
    val img: String,
    @PrimaryKey
    val id: String,
)