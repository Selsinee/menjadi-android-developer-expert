package com.dicoding.animelist.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dicoding.animelist.core.data.source.local.entity.AnimeEntity

/**
 * Created by Seline on 02/03/2022 15:01
 */
@Database(version = 1, entities = [AnimeEntity::class], exportSchema = false)
abstract class AnimeDatabase : RoomDatabase() {

    abstract fun animeDao(): com.dicoding.animelist.core.data.source.local.room.AnimeDao

}