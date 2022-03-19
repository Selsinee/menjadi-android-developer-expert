package com.dicoding.animelist.di

import com.dicoding.animelist.core.domain.usecase.AnimeInteractor
import com.dicoding.animelist.core.domain.usecase.AnimeUseCase
import com.dicoding.animelist.favourite.FavoriteViewModel
import com.dicoding.animelist.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Seline on 02/03/2022 17:37
 */

val useCaseModule = module {
    factory<AnimeUseCase> { AnimeInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
//    viewModel { DetailTourismViewModel(get()) }
}