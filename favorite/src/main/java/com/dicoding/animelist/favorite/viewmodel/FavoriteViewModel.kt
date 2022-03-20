package com.dicoding.animelist.favorite.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.animelist.core.domain.usecase.AnimeUseCase

/**
 * Created by Seline on 20/03/2022 13:34
 */
class FavoriteViewModel(animeUseCase: AnimeUseCase) : ViewModel() {
    val animes = animeUseCase.getFavoriteAnimes().asLiveData()
}