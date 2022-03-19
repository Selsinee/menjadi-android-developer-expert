package com.dicoding.animelist.core.data

import android.util.Log
import com.dicoding.animelist.core.data.source.local.LocalDataSource
import com.dicoding.animelist.core.data.source.remote.RemoteDataSource
import com.dicoding.animelist.core.data.source.remote.network.ApiResponse
import com.dicoding.animelist.core.data.source.remote.response.AnimeResponse
import com.dicoding.animelist.core.domain.model.Anime
import com.dicoding.animelist.core.domain.repository.IAnimeRepository
import com.dicoding.animelist.core.utils.AppExecutors
import com.dicoding.animelist.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Created by Seline on 02/03/2022 16:49
 */
class AnimeRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: com.dicoding.animelist.core.data.source.local.LocalDataSource,
    private val appExecutors: AppExecutors
) : IAnimeRepository {

    override fun getAllAnimes(): Flow<com.dicoding.animelist.core.data.Resource<List<Anime>>> =
        object : com.dicoding.animelist.core.data.NetworkBoundResource<List<Anime>, List<AnimeResponse>>() {
            override fun loadFromDB(): Flow<List<Anime>> {
                return localDataSource.getAllAnimes().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Anime>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<AnimeResponse>>> =
                remoteDataSource.getAllAnimes()

            override suspend fun saveCallResult(data: List<AnimeResponse>) {
                val animeList = DataMapper.mapResponsesToEntities(data)
                Log.d("<TAG>DB", animeList.toString())
                localDataSource.insertAnimes(animeList)
            }
        }.asFlow()

    override fun getFavoriteAnimes(): Flow<List<Anime>> {
        return localDataSource.getFavoriteAnimes().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteAnime(anime: Anime, state: Boolean) {
        val animeEntity = DataMapper.mapDomainToEntity(anime)
        appExecutors.diskIO().execute { localDataSource.setFavoriteAnime(animeEntity, state) }
    }

}