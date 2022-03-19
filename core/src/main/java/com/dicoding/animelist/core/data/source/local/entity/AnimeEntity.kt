package com.dicoding.animelist.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Seline on 02/03/2022 14:57
 */

@Entity(tableName = "Animes")
data class AnimeEntity (
    @PrimaryKey
    @NonNull
    var animeId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "synopsis")
    var synopsis: String,

    @ColumnInfo(name = "airedDate")
    var airedDate: String,

    @ColumnInfo(name = "type")
    var type: String,

    @ColumnInfo(name = "source")
    var source: String,

    @ColumnInfo(name = "episodes")
    var episodes: String,

    @ColumnInfo(name = "score")
    var score: String,

    @ColumnInfo(name = "imageURL")
    var imageURL: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)