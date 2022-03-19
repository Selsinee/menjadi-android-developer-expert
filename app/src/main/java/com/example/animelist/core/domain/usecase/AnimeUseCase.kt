package com.example.animelist.core.domain.usecase

import com.example.animelist.core.data.Resource
import com.example.animelist.core.domain.model.Anime
import kotlinx.coroutines.flow.Flow

/**
 * Created by Seline on 02/03/2022 16:56
 */
interface AnimeUseCase {
    fun getAllAnimes(): Flow<Resource<List<Anime>>>
    fun getFavoriteAnimes(): Flow<List<Anime>>
    fun setFavoriteAnime(anime: Anime, state: Boolean)
}