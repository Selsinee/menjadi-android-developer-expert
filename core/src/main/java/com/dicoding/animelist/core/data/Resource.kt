package com.dicoding.animelist.core.data

/**
 * Created by Seline on 02/03/2022 14:46
 */
sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : com.dicoding.animelist.core.data.Resource<T>(data)
    class Loading<T>(data: T? = null) : com.dicoding.animelist.core.data.Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : com.dicoding.animelist.core.data.Resource<T>(data, message)
}
