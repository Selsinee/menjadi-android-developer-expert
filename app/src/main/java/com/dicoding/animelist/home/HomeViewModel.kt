package com.dicoding.animelist.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.animelist.core.domain.usecase.AnimeUseCase

/**
 * Created by Seline on 09/03/2022 15:06
 */
class HomeViewModel(animeUseCase: AnimeUseCase) : ViewModel() {
    val animes = animeUseCase.getAllAnimes().asLiveData()
}