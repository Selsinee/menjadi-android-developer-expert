package com.example.animelist.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.animelist.core.data.source.local.entity.AnimeEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Seline on 02/03/2022 15:02
 */
@Dao
interface AnimeDao {

    @Query("SELECT * FROM Animes")
    fun getAllAnimes(): Flow<List<AnimeEntity>>

    @Query("SELECT * FROM Animes where isFavorite = 1")
    fun getFavoriteAnimes(): Flow<List<AnimeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnimes(tourism: List<AnimeEntity>)

    @Update
    fun updateFavoriteAnime(tourism: AnimeEntity)
}