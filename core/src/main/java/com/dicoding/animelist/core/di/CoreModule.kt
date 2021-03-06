package com.dicoding.animelist.core.di

import androidx.room.Room
import com.dicoding.animelist.core.data.AnimeRepository
import com.dicoding.animelist.core.data.source.local.LocalDataSource
import com.dicoding.animelist.core.data.source.local.room.AnimeDatabase
import com.dicoding.animelist.core.data.source.remote.RemoteDataSource
import com.dicoding.animelist.core.data.source.remote.network.ApiService
import com.dicoding.animelist.core.domain.repository.IAnimeRepository
import com.dicoding.animelist.core.utils.AppExecutors
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Seline on 02/03/2022 17:14
 */

val databaseModule = module {
    factory { get<AnimeDatabase>().animeDao() }
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("dicodinganimelist".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            AnimeDatabase::class.java, "Anime.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}

val networkModule = module {
    single {
        val hostname = "docs.api.jikan.moe"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, "sha256/qHYIZRBifDC6wha0jaT3dmJOYCHMkIk4cnwyY1FZKCE=")
            .build()

        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v4/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IAnimeRepository> {
        AnimeRepository(
            get(),
            get(),
            get()
        )
    }
}