package com.dicoding.animelist.core.utils

import com.dicoding.animelist.core.data.source.local.entity.AnimeEntity
import com.dicoding.animelist.core.data.source.remote.response.AnimeResponse
import com.dicoding.animelist.core.domain.model.Anime

/**
 * Created by Seline on 02/03/2022 17:04
 */
object DataMapper {

    fun mapResponsesToEntities(input: List<AnimeResponse>): List<AnimeEntity> {
        val animeList = ArrayList<AnimeEntity>()
        input.map {
            val anime = AnimeEntity(
                it.animeId,
                it.title.ifEmpty { "" },
                it.synopsis,
                it.airedDate.date,
                it.type,
                it.source,
                it.episodes,
                it.score,
                it.image.jpg.imageURL,
                false
            )
            animeList.add(anime)
        }
        return animeList
    }

    fun mapEntitiesToDomain(input: List<AnimeEntity>): List<Anime> =
        input.map {
            Anime(
                it.animeId,
                it.title,
                it.synopsis,
                it.airedDate,
                it.type,
                it.source,
                it.episodes,
                it.score,
                it.imageURL,
                it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Anime) = AnimeEntity(
        input.animeId,
        input.title,
        input.synopsis,
        input.airedDate,
        input.type,
        input.source,
        input.episodes,
        input.score,
        input.imageURL,
        input.isFavorite
    )

}