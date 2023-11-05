package com.paawk4.hammertestapp.data.remote

import com.paawk4.hammertestapp.domain.models.Meals
import com.paawk4.hammertestapp.domain.utils.Result

class RetrofitService {

    private val api = RetrofitInstance.create()

    fun getAllMeals(): Result<Meals> {
        val callResponse = api.getAllMeals()
        try {
            val response = callResponse.execute()

            if (response.isSuccessful) {
                response.body()?.let {
                    return Result.Success(it)
                }
            }
            return Result.Failure(Exception(response.message()))
        } catch (_: Exception) {
            return Result.Failure(Exception("no internet connection"))
        }
    }
}