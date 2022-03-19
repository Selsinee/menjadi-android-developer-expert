package com.dicoding.animelist.core.data.source.remote.response;

import com.google.gson.annotations.SerializedName

/**
 * Created by Seline on 02/03/2022 15:15
 */
data class AnimeResponse (
    @SerializedName("mal_id")
    val animeId: String,

    @SerializedName("title")
    val title: String = "",

    @SerializedName("synopsis")
    val synopsis: String,

    @SerializedName("aired")
    val airedDate: com.dicoding.animelist.core.data.source.remote.response.AiredResponse,

    @SerializedName("type")
    val type: String,

    @SerializedName("source")
    val source: String,

    @SerializedName("episodes")
    val episodes: String,

    @SerializedName("score")
    val score: String,

    @SerializedName("images")
    val image: com.dicoding.animelist.core.data.source.remote.response.ImageResponse
)
