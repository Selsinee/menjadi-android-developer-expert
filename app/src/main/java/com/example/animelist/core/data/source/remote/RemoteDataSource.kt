package com.example.animelist.core.data.source.remote

import android.util.Log
import com.example.animelist.core.data.source.remote.network.ApiResponse
import com.example.animelist.core.data.source.remote.network.ApiService
import com.example.animelist.core.data.source.remote.response.AnimeResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by Seline on 02/03/2022 16:07
 */
class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllAnimes(): Flow<ApiResponse<List<AnimeResponse>>> {
        return flow {
            try {
                val response = apiService.getAnimeList()
                val dataArray = response.data
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

}