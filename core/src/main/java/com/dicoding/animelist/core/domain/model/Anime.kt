package com.dicoding.animelist.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Seline on 02/03/2022 14:30
 */
@Parcelize
data class Anime (
        val animeId: String,
        val title: String,
        val synopsis: String,
        val airedDate: String,
        val type: String,
        val source: String,
        val episodes: String,
        val score: String,
        val imageURL: String,
        val isFavorite: Boolean
) : Parcelable