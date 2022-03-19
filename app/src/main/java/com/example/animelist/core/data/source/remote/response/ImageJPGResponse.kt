package com.example.animelist.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

/**
 * Created by Seline on 02/03/2022 16:04
 */
data class ImageJPGResponse (
    @SerializedName("image_url")
    val imageURL: String
)