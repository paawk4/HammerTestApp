package com.paawk4.hammertestapp.data.repos

import com.paawk4.hammertestapp.data.local.MealDao
import com.paawk4.hammertestapp.data.remote.RetrofitService
import com.paawk4.hammertestapp.domain.models.Meal
import com.paawk4.hammertestapp.domain.models.MealEntity
import com.paawk4.hammertestapp.domain.models.Meals
import com.paawk4.hammertestapp.domain.repos.MealsRepository
import com.paawk4.hammertestapp.domain.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MealsRepositoryImpl(
    private val retrofit: RetrofitService,
    private val mealDao: MealDao
) : MealsRepository {
    override suspend fun getAllMealsFromApi(): Result<Meals> {
        when (val result = withContext(Dispatchers.IO) { retrofit.getAllMeals() }) {
            is Result.Success -> {
                val listForDb = result.data.meals.map {
                    MealEntity(
                        id = it.id,
                        name = it.name,
                        img = it.img
                    )
                }
                mealDao.insertMeals(meals = listForDb)
                return Result.Success(Meals(result.data.meals))
            }

            is Result.Failure -> {
                val resultFromDb = mealDao.getAllMeals()
                if (resultFromDb.isNotEmpty()) {
                    val list = resultFromDb.map {
                        Meal(
                            id = it.id,
                            name = it.name,
                            img = it.img
                        )
                    }
                    return Result.Success(Meals(list))
                }
                return result
            }
        }
    }

    override fun getAllMealsFromDb(): List<MealEntity> {
        return mealDao.getAllMeals()
    }

    override fun insertAllMealsIntoDb(meals: List<MealEntity>) {
        mealDao.insertMeals(meals = meals)
    }
}