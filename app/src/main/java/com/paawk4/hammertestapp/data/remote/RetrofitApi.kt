package com.paawk4.hammertestapp.data.remote

import com.paawk4.hammertestapp.domain.models.Meals
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApi {

    @GET("1/filter.php?a=Italian")
    fun getAllMeals(): Call<Meals>

}