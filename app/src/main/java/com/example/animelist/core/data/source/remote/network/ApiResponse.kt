package com.example.animelist.core.data.source.remote.network

/**
 * Created by Seline on 02/03/2022 15:14
 */
sealed class ApiResponse<out R> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val errorMessage: String) : ApiResponse<Nothing>()
    object Empty : ApiResponse<Nothing>()
}