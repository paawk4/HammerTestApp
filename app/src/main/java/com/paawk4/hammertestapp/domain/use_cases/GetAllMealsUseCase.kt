package com.paawk4.hammertestapp.domain.use_cases

import com.paawk4.hammertestapp.domain.repos.MealsRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class GetAllMealsUseCase : KoinComponent {
    private val repository: MealsRepository by inject()
    suspend operator fun invoke() = repository.getAllMealsFromApi()
}