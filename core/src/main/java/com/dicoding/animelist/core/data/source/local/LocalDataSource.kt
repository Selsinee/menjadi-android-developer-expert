package com.dicoding.animelist.core.data.source.local

import com.dicoding.animelist.core.data.source.local.entity.AnimeEntity
import com.dicoding.animelist.core.data.source.local.room.AnimeDao
import kotlinx.coroutines.flow.Flow

/**
 * Created by Seline on 02/03/2022 15:07
 */
class LocalDataSource(private val animeDao: AnimeDao) {

    fun getAllAnimes(): Flow<List<AnimeEntity>> = animeDao.getAllAnimes()

    fun getFavoriteAnimes(): Flow<List<AnimeEntity>> = animeDao.getFavoriteAnimes()

    suspend fun insertAnimes(animeList: List<AnimeEntity>) = animeDao.insertAnimes(animeList)

    fun setFavoriteAnime(anime: AnimeEntity, newState: Boolean) {
        anime.isFavorite = newState
        animeDao.updateFavoriteAnime(anime)
    }

}