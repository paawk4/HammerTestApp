package com.paawk4.hammertestapp.domain.repos

import com.paawk4.hammertestapp.domain.models.Meal
import com.paawk4.hammertestapp.domain.models.MealEntity
import com.paawk4.hammertestapp.domain.models.Meals
import com.paawk4.hammertestapp.domain.utils.Result

interface MealsRepository {

    suspend fun getAllMealsFromApi(): Result<Meals>

    fun getAllMealsFromDb(): List<MealEntity>

    fun insertAllMealsIntoDb(meals: List<MealEntity>)
}