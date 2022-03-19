package com.dicoding.animelist.core.data.source.remote.network

import com.dicoding.animelist.core.data.source.remote.response.ListAnimeResponse
import retrofit2.http.GET

/**
 * Created by Seline on 02/03/2022 16:05
 */
interface ApiService {
    @GET("top/anime")
    suspend fun getAnimeList(): ListAnimeResponse
}