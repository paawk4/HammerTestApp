package com.paawk4.hammertestapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.paawk4.hammertestapp.domain.models.MealEntity

const val HAMMER_DATA_BASE = "hammer-db"

@Database(
    version = 1,
    entities = [MealEntity::class]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getMealDao(): MealDao
}