package com.dicoding.animelist.detail

import androidx.lifecycle.ViewModel
import com.dicoding.animelist.core.domain.model.Anime
import com.dicoding.animelist.core.domain.usecase.AnimeUseCase

/**
 * Created by Seline on 20/03/2022 14:43
 */
class DetailViewModel(private val animeUseCase: AnimeUseCase) : ViewModel() {
    fun setAnimeAsFavorite(anime: Anime, newStatus: Boolean) {
        animeUseCase.setFavoriteAnime(anime, newStatus)
    }
}