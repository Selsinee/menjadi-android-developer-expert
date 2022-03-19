package com.dicoding.animelist.core.domain.usecase

import com.dicoding.animelist.core.domain.model.Anime
import com.dicoding.animelist.core.domain.repository.IAnimeRepository

/**
 * Created by Seline on 02/03/2022 16:57
 */
class AnimeInteractor(private val animeRepository: IAnimeRepository) : AnimeUseCase {

    override fun getAllAnimes() = animeRepository.getAllAnimes()

    override fun getFavoriteAnimes() = animeRepository.getFavoriteAnimes()

    override fun setFavoriteAnime(anime: Anime, state: Boolean) =
        animeRepository.setFavoriteAnime(anime, state)
}