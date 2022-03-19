package com.dicoding.animelist.core.data.source.remote.network

/**
 * Created by Seline on 02/03/2022 15:14
 */
sealed class ApiResponse<out R> {
    data class Success<out T>(val data: T) : com.dicoding.animelist.core.data.source.remote.network.ApiResponse<T>()
    data class Error(val errorMessage: String) : com.dicoding.animelist.core.data.source.remote.network.ApiResponse<Nothing>()
    object Empty : com.dicoding.animelist.core.data.source.remote.network.ApiResponse<Nothing>()
}