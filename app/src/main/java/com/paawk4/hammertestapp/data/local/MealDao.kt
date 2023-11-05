package com.paawk4.hammertestapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.paawk4.hammertestapp.domain.models.MealEntity
import com.paawk4.hammertestapp.domain.utils.Result

@Dao
interface MealDao {

    @Insert(entity = MealEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertMeals(meals: List<MealEntity>)

    @Query("SELECT * FROM meals")
    fun getAllMeals(): List<MealEntity>
}