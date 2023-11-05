package com.paawk4.hammertestapp.presentation.viewmodels

import com.paawk4.hammertestapp.domain.models.Meal
import com.paawk4.hammertestapp.domain.use_cases.GetAllMealsUseCase
import com.paawk4.hammertestapp.domain.utils.Data
import com.paawk4.hammertestapp.domain.utils.Result
import com.paawk4.hammertestapp.domain.utils.Status
import com.paawk4.hammertestapp.presentation.utils.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MenuViewModel(
    private val getAllMealsUseCase: GetAllMealsUseCase
) : BaseViewModel() {

    private val _mealsList =
        MutableStateFlow<Data<List<Meal>>>(Data(responseType = Status.LOADING))
    val mealsList: StateFlow<Data<List<Meal>>> = _mealsList.asStateFlow()

    init {
        requestMeals()
    }

    fun requestMeals() = launch {
        _mealsList.value = Data(responseType = Status.LOADING)
        when (val result = withContext(Dispatchers.IO) { getAllMealsUseCase() }) {
            is Result.Success -> {
                _mealsList.value = Data(responseType = Status.SUCCESSFUL, data = result.data.meals)
            }
            is Result.Failure -> {
                _mealsList.value = Data(responseType = Status.ERROR, error = result.exception)
            }
        }
    }
}