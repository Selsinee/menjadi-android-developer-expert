package com.example.animelist.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

/**
 * Created by Seline on 02/03/2022 16:00
 */
data class AiredResponse (
    @SerializedName("string")
    val date: String
)