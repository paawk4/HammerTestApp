package com.paawk4.hammertestapp.di

import androidx.room.Room
import com.paawk4.hammertestapp.data.local.AppDatabase
import com.paawk4.hammertestapp.data.local.HAMMER_DATA_BASE
import com.paawk4.hammertestapp.data.remote.RetrofitService
import com.paawk4.hammertestapp.data.repos.MealsRepositoryImpl
import com.paawk4.hammertestapp.domain.repos.MealsRepository
import com.paawk4.hammertestapp.domain.use_cases.GetAllMealsUseCase
import com.paawk4.hammertestapp.presentation.viewmodels.MenuViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectFeature() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(
        listOf(
            repositoriesModule,
            viewModelsModule,
            useCasesModule,
            databaseModule
        )
    )
}

val databaseModule = module {
    single { Room.databaseBuilder(get(), AppDatabase::class.java, HAMMER_DATA_BASE).build() }
    single { get<AppDatabase>().getMealDao() }
}

val repositoriesModule = module {
    single { RetrofitService() }
    single<MealsRepository> { MealsRepositoryImpl(get(), get()) }
}

val viewModelsModule = module {
    viewModel { MenuViewModel(get()) }
}

val useCasesModule = module {
    single { GetAllMealsUseCase() }
}