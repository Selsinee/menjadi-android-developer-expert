package com.example.animelist.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.animelist.core.domain.usecase.AnimeUseCase

/**
 * Created by Seline on 09/03/2022 15:06
 */
class HomeViewModel(animeUseCase: AnimeUseCase) : ViewModel() {
    val animes = animeUseCase.getAllAnimes().asLiveData()
}