package com.dicoding.animelist.favorite.di

import com.dicoding.animelist.favorite.viewmodel.FavoriteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Seline on 20/03/2022 13:36
 */
val favoriteModule = module {
    viewModel { FavoriteViewModel(get()) }
}