package com.dicoding.animelist.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

/**
 * Created by Seline on 02/03/2022 16:02
 */
data class ImageResponse (

    @SerializedName("jpg")
    val jpg: com.dicoding.animelist.core.data.source.remote.response.ImageJPGResponse
)