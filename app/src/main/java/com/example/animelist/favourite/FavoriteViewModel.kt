package com.example.animelist.favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.animelist.core.domain.usecase.AnimeUseCase

class FavoriteViewModel(animeUseCase: AnimeUseCase) : ViewModel() {
    val animes = animeUseCase.getFavoriteAnimes().asLiveData()
}