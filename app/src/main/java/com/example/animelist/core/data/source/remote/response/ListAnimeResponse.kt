package com.example.animelist.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

/**
 * Created by Seline on 02/03/2022 15:15
 */
data class ListAnimeResponse(
    @SerializedName("data")
    val data: List<AnimeResponse> = arrayListOf()
)